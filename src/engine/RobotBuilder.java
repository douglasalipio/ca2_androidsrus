/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.util.ArrayList;
import java.util.List;
import mvp.Robot;

/**
 *
 * @author hal-9000
 */
public class RobotBuilder {

    private static final RobotBuilder instance = new RobotBuilder();
    private static final int BUNCH_SIZE = 600;
    private ToolsBuilder toolsBuilder = ToolsBuilder.instance();

    private RobotBuilder() {

    }

    public static RobotBuilder instance() {
        return instance;
    }

    public List<Robot> v1Bunch() {
        List<Robot> robotsContainer = new ArrayList();
        for (int i = 0; i < BUNCH_SIZE; i++) {
            Robot robot = new Robot(toolsBuilder.model(),
                    toolsBuilder.brain(),
                    toolsBuilder.mobility(),
                    toolsBuilder.vision(),
                    toolsBuilder.arms(),
                    toolsBuilder.mediaCenter(),
                    toolsBuilder.powerPlant());
            robotsContainer.add(robot);
        }

        return robotsContainer;
    }
}
