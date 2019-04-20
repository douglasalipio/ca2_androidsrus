/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp;

import builder.RobotBuilder;
import entity.Robot;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hal-9000
 */
public class RobotPresenter implements RobotContract.BasePresenter {

    private final RobotBuilder robotBuilder = RobotBuilder.instance();
    private RobotContract.BaseView view;

    @Override
    public void attach(RobotContract.BaseView view) {
        this.view = view;
    }

    @Override
    public void submitV1Androids() {
        Robot[] allV1 = robotBuilder.allV1Androids();
        if (allV1 != null) {
            view.printAllAndroidV1(allV1);
        }
    }

    @Override
    public void submitV2Androids() {
        Robot[] allV2 = robotBuilder.allV2Androids();
        if (allV2 != null) {
            view.printAllAndroidV2(allV2);
        }
    }

    @Override
    public void findRobotByModel(String model) {
        List<Robot> robots = new ArrayList();
        if (robotBuilder.allV1Androids() != null && robotBuilder.allV2Androids() != null) {
            robots.addAll(searchRobotByModel(model, robotBuilder.allV2Androids()));
            robots.addAll(searchRobotByModel(model, robotBuilder.allV1Androids()));
            view.showRobotsByModel(robots);
        } else {
            view.onErrorEmptylist();
        }

    }

    private List<Robot> searchRobotByModel(String model, Robot[] robots) {
        List<Robot> robotsContainer = new ArrayList();
        for (Robot robot : robots) {
            if (robot.getModel().trim().equals(model.trim())) {
                robotsContainer.add(robot);
            }
        }

        return robotsContainer;
    }

    private int searchTotalModelAvailable(String model, Robot[] robots) {
        int totalCount = 0;
        for (Robot robot : robots) {
            if (robot.getModel().trim().toLowerCase()
                    .equals(model.trim().toLowerCase())) {
                totalCount++;
            }
        }

        return totalCount;
    }

    @Override
    public void findTotalTypes(String model) {
        int totalCount = 0;
        if (robotBuilder.allV1Androids() != null
                && robotBuilder.allV2Androids() != null) {
            totalCount += +searchTotalModelAvailable(model, robotBuilder.allV1Androids());
            totalCount += +searchTotalModelAvailable(model, robotBuilder.allV2Androids());
            view.showTotalCountsAvaliable("Total count for " + model + "is " + totalCount);
        } else {
            view.onErrorEmptylist();
        }
    }
}
