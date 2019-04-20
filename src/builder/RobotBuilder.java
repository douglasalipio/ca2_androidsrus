/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mvp.Robot;

/**
 *
 * @author hal-9000
 */
public class RobotBuilder {

    private static final RobotBuilder instance = new RobotBuilder();
    private static final int V1_BUNCH_SIZE = 600;
    private static final int V2_BUNCH_SIZE = 400;
    private ToolsBuilder toolsBuilder = ToolsBuilder.instance();
    private List<Robot> androids = new ArrayList();

    private RobotBuilder() {

    }

    public static RobotBuilder instance() {
        return instance;
    }

    public List<Robot> v1Bunch() {
        for (int i = 0; i < V1_BUNCH_SIZE; i++) {
            Robot robot = new Robot(toolsBuilder.model(),
                    toolsBuilder.brain(),
                    toolsBuilder.mobility(),
                    toolsBuilder.vision(),
                    toolsBuilder.arms(),
                    toolsBuilder.mediaCenter(),
                    toolsBuilder.powerPlant());
            androids.add(robot);
        }

        return androids;
    }

    public List<Robot> v2Bunch() {
        List<Robot> robotsContainer = new ArrayList();
        if (!androids.isEmpty()) {
            for (int i = 0; i < V2_BUNCH_SIZE; i++) {
                Robot v1Android = androids.get(numberBetweenZeroTo());
                do {
                    Robot v2Android = new Robot(toolsBuilder.model(),
                            toolsBuilder.brain(),
                            toolsBuilder.mobility(),
                            toolsBuilder.vision(),
                            toolsBuilder.arms(),
                            toolsBuilder.mediaCenter(),
                            toolsBuilder.powerPlant());
                    robotsContainer.add(v2Android);
                } while (v1Android.isDonate());
            }
        }

        return robotsContainer;
    }

    /**
     * Generating a random number to access the robot list.
     *
     * @param value size of list
     * @return number
     */
    private int numberBetweenZeroTo() {
        int radomNumber = new Random().nextInt(androids.size());
        Robot robot = androids.get(radomNumber);
        if (!robot.isDonate()) {
            numberBetweenZeroTo();
        }
        return radomNumber;
    }
}
