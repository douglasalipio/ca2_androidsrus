/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import entity.Component;
import java.util.Random;
import entity.Robot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.tuple.MutablePair;

/**
 * Creating a list of robots.
 *
 * @author hal-9000
 */
public class RobotBuilder {

    private static RobotBuilder INSTANCE;
    private static final int V1_BUNCH_SIZE = 600;
    private static final int V2_BUNCH_SIZE = 400;
    private final ToolsBuilder toolsBuilder = ToolsBuilder.instance();
    private Robot[] v1Androids = null;
    private Robot[] v2Androids = null;

    /**
     * Building both generations for the first time.
     */
    private RobotBuilder() {
        v1Bunch();
        v2Bunch();
    }

    /**
     * Instance of robot object.
     *
     * @return
     */
    public static RobotBuilder instance() {
        if (INSTANCE == null) {
            return new RobotBuilder();
        }
        return INSTANCE;
    }

    /**
     * Building first generation.
     *
     * @return
     */
    private Robot[] v1Bunch() {
        v1Androids = new Robot[V1_BUNCH_SIZE];
        for (int i = 0; i < V1_BUNCH_SIZE; i++) {
            Robot robot = new Robot(toolsBuilder.v1Model());
            robot.attachComponent(toolsBuilder.buildDefaultComponents(robot.getSerialNumber()));
            v1Androids[i] = robot;
        }

        return v1Androids;
    }

    /**
     * Building second generation.
     *
     * @return
     */
    private Robot[] v2Bunch() {
        v2Androids = new Robot[V2_BUNCH_SIZE];
        for (int i = 0; i < V2_BUNCH_SIZE; i++) {
            Robot v2Robot = new Robot(toolsBuilder.v2Model());
            v2Androids[i] = embedComponents(v2Robot, Component.list());
        }
        return v2Androids;
    }

    /**
     * Embed brain component.
     *
     * @param newRobot
     */
    private Robot embedComponents(Robot newRobot, List<Component.Type> types) {
        for (Component.Type type : types) {
            Robot robot = findDonator(type);
            var component = robot.donateComponent(type);
            newRobot.attachComponent(component);
        }
        return newRobot;
    }

    /**
     * Trying to found a donator only robots v1.
     *
     * @return donator
     */
    private Robot findDonator(Component.Type type) {
        Robot v1Android = v1Androids[sortIndex()];
        var component = v1Android.getComponents()
                .stream()
                .filter(it -> it.getValue().getType() == type)
                .findAny()
                .orElse(null);

        if (!v1Android.isDonate() && component != null) {
            findDonator(type);
        }
        return v1Android;
    }

    /**
     * Building a random index between 0 to size list.
     *
     * @param value size of list
     * @return number
     */
    private int sortIndex() {
        return new Random().nextInt(v1Androids.length);
    }

    /**
     * All Android v2.
     *
     * @return list of androids.
     */
    public Robot[] allV2Androids() {
        return v2Androids;
    }

    /**
     * All Android v1.
     *
     * @return list of androids.
     */
    public Robot[] allV1Androids() {
        return v1Androids;
    }

    /**
     * Sorting androids v1 and androids v2 in a list.
     *
     * @return
     */
    public List<Robot> allAndroids() {
        List<Robot> androids = new ArrayList();
        androids.addAll(Arrays.asList(v1Androids));
        androids.addAll(Arrays.asList(v2Androids));
        return androids;
    }
}
