/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import java.util.Random;
import entity.Robot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * Building first generation.
     *
     * @return
     */
    public Robot[] v1Bunch() {
        v1Androids = new Robot[V1_BUNCH_SIZE];
        for (int i = 0; i < V1_BUNCH_SIZE; i++) {
            Robot robot = new Robot(toolsBuilder.v1Model(),
                    toolsBuilder.brain(),
                    toolsBuilder.mobility(),
                    toolsBuilder.vision(),
                    toolsBuilder.arms(),
                    toolsBuilder.mediaCenter(),
                    toolsBuilder.powerPlant());
            v1Androids[i] = robot;
        }

        return v1Androids;
    }

    /**
     * Building second generation.
     *
     * @return
     */
    public Robot[] v2Bunch() {
        v2Androids = new Robot[V2_BUNCH_SIZE];
        for (int i = 0; i < V2_BUNCH_SIZE; i++) {
            Robot v2Robot = new Robot();
            v2Robot.attachModel(toolsBuilder.v2Model());
            embedBrainIn(v2Robot);
            embedMobilityIn(v2Robot);
            embedVisionIn(v2Robot);
            embedArmsIn(v2Robot);
            embedMediaCenterIn(v2Robot);
            embedPowerPlantIn(v2Robot);
            v2Androids[i] = v2Robot;
        }
        return v2Androids;
    }

    /**
     * Embed brain component.
     *
     * @param newRobot
     */
    private void embedBrainIn(Robot newRobot) {
        while (newRobot.getBrain() == null) {
            Robot donator = findDonator();
            if (!donator.getBrain().getValue().isBlank()) {
                newRobot.attachBrain(donator
                        .donateBrain(newRobot.getSerialNumber()));
            }
        }
    }

    /**
     * Embed mobility component.
     *
     * @param newRobot
     */
    private void embedMobilityIn(Robot newRobot) {
        while (newRobot.getMobility() == null) {
            Robot donator = findDonator();
            if (!donator.getMobility().getValue().isBlank()) {
                newRobot.attachMobility(donator
                        .donateMobility(newRobot.getSerialNumber()));
            }
        }
    }

    /**
     * Embed a vision component.
     *
     * @param newRobot
     */
    private void embedVisionIn(Robot newRobot) {
        while (newRobot.getVision() == null) {
            Robot donator = findDonator();
            if (!donator.getVision().getValue().isBlank()) {
                newRobot.attachVision(donator
                        .donateVision(newRobot.getSerialNumber()));
            }
        }
    }

    /**
     * Embed arms components.
     *
     * @param newRobot
     */
    private void embedArmsIn(Robot newRobot) {
        while (newRobot.getArms() == null) {
            Robot donator = findDonator();
            if (!donator.getArms().getValue().isBlank()) {
                newRobot.attachArms(donator
                        .donatehArms(newRobot.getSerialNumber()));
            }
        }
    }

    /**
     * Embed a media center component.
     *
     * @param newRobot
     */
    private void embedMediaCenterIn(Robot newRobot) {
        while (newRobot.getMediaCenter() == null) {
            Robot donator = findDonator();
            if (!donator.getMediaCenter().getValue().isBlank()) {
                newRobot.attachMediaCenter(donator
                        .donateMediaCenter(newRobot.getSerialNumber()));
            }
        }
    }

    /**
     * Embed a power plant component.
     *
     * @param newRobot
     */
    private void embedPowerPlantIn(Robot newRobot) {
        while (newRobot.getPowerPlant() == null) {
            Robot donator = findDonator();
            if (!donator.getPowerPlant().getValue().isBlank()) {
                newRobot.attachPowerPlant(donator
                        .donatePowerPlant(newRobot.getSerialNumber()));
            }
        }
    }

    /**
     * Trying to found a donator only robots v1.
     *
     * @return donator
     */
    private Robot findDonator() {
        Robot v1Android = v1Androids[sortIndex()];
        if (!v1Android.isDonate()) {
            findDonator();
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
