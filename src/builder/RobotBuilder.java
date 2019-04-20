/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import entity.Robot;

/**
 *
 * @author hal-9000
 */
public class RobotBuilder {

    private static final RobotBuilder instance = new RobotBuilder();
    private static final int V1_BUNCH_SIZE = 600;
    private static final int V2_BUNCH_SIZE = 400;
    private ToolsBuilder toolsBuilder = ToolsBuilder.instance();
    private Robot[] v1Androids = null;
    private Robot[] v2Androids = null;

    private RobotBuilder() {

    }

    public static RobotBuilder instance() {
        return instance;
    }

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

    public Robot[] v2Bunch() {
        v2Androids = new Robot[V2_BUNCH_SIZE];
        for (int i = 0; i < V2_BUNCH_SIZE; i++) {
            Robot v2Robot = new Robot();
            v2Robot.attachMoodel(toolsBuilder.v2Model());
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

    public Robot[] allV2Androids() {
        return v2Androids;
    }

    public Robot[] allV1Androids() {
        return v1Androids;
    }

    private void embedBrainIn(Robot newRobot) {
        while (newRobot.getBrain() == null || newRobot.getBrain().isBlank()) {
            Robot candidate = donatorRobot();
            if (candidate.isDonate() && (!candidate.getBrain().isBlank())) {
                newRobot.attachBrain(candidate.getBrain());
            }
        }
    }

    private void embedMobilityIn(Robot newRobot) {
        while (newRobot.getMobility() == null || newRobot.getMobility().isBlank()) {
            Robot donator = donatorRobot();
            if (donator.isDonate() && (!donator.getMobility().isBlank())) {
                newRobot.attachMobility(donator.getMobility());
            }
        }
    }

    private void embedVisionIn(Robot newRobot) {
        while (newRobot.getVision() == null || newRobot.getVision().isBlank()) {
            Robot donator = donatorRobot();
            if (donator.isDonate() && (!donator.getVision().isBlank())) {
                newRobot.attachVision(donator.getVision());
            }
        }
    }

    private void embedArmsIn(Robot newRobot) {
        while (newRobot.getArms() == null || newRobot.getArms().isBlank()) {
            Robot donator = donatorRobot();
            if (donator.isDonate() && (!donator.getArms().isBlank())) {
                newRobot.attachArms(donator.getArms());
            }
        }
    }

    private void embedMediaCenterIn(Robot newRobot) {
        while (newRobot.getMediaCenter() == null || newRobot.getMediaCenter().isBlank()) {
            Robot donator = donatorRobot();
            if (donator.isDonate() && (!donator.getMediaCenter().isBlank())) {
                newRobot.attachMediaCenter(donator.getMediaCenter());
            }
        }
    }

    private void embedPowerPlantIn(Robot newRobot) {
        while (newRobot.getPowerPlant() == null || newRobot.getPowerPlant().isBlank()) {
            Robot donator = donatorRobot();
            if (donator.isDonate() && (!donator.getPowerPlant().isBlank())) {
                newRobot.attachPowerPlant(donator.getPowerPlant());
            }
        }
    }

    private Robot donatorRobot() {
        Robot v1Android = v1Androids[sortIndex()];
        if (!v1Android.isDonate()) {
            donatorRobot();
        }
        return v1Android;
    }

    /**
     * Generating a random index between 0 to size list.
     *
     * @param value size of list
     * @return number
     */
    private int sortIndex() {
        return new Random().nextInt(v1Androids.length);
    }
}
