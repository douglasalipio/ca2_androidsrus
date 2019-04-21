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
public class DroidRusPresenter implements DroidsRusContract.BasePresenter {

    private final RobotBuilder robotBuilder = RobotBuilder.instance();
    private DroidsRusContract.BaseView view;
    private final List<Robot> robots = robotBuilder.allAndroids();

    @Override
    public void attach(DroidsRusContract.BaseView view) {
        this.view = view;
    }

    @Override
    public void submitV1Androids() {
        view.printAllAndroidV1(robotBuilder.allV1Androids());
    }

    @Override
    public void submitV2Androids() {
        view.printAllAndroidV2(robotBuilder.allV2Androids());
    }

    @Override
    public void findRobotByModel(String model) {
        if (robots != null) {
            view.showRobotsByModel(searchRobotByModel(model, robots));
        }

    }

    @Override
    public void findTotalTypes(String model) {
        int totalCount = 0;
        if (robots != null) {
            totalCount += searchTotalModelAvailable(model, robots);
            view.showTotalCountsAvaliable("Total count for " + model + " is " + totalCount);
        }
    }

    @Override
    public void findDRoidDonatiors(String model) {
        for (Robot droidReceiver : searchRobotByModel(model, robots)) {
            view.showDroidDonators(droidReceiver, searchDonatorParts(droidReceiver));
            break;
        }
    }

    private List<Robot> searchDonatorParts(Robot donator) {
        List<Robot> robotContainer = new ArrayList();
        robotContainer.add(searchRobotById(donator.getBrain().getKey()));
        robotContainer.add(searchRobotById(donator.getMobility().getKey()));
        robotContainer.add(searchRobotById(donator.getVision().getKey()));
        robotContainer.add(searchRobotById(donator.getArms().getKey()));
        robotContainer.add(searchRobotById(donator.getMediaCenter().getKey()));
        robotContainer.add(searchRobotById(donator.getPowerPlant().getKey()));
        //mergeDroids(robotContainer);
        return robotContainer;
    }

    private void mergeDroids(List<Robot> robots) {
        for (int i = 0; i < robots.size(); i++) {
            for (int j = 0; j < robots.size(); j++) {
                if (robots.get(i).getSerialNumber() == robots.get(j).getSerialNumber()) {
                    robots.remove(j);
                }
            }
        }
    }

    private Robot searchRobotById(long serialNumber) {
        for (Robot robot : robots) {
            if (robot.getSerialNumber() == serialNumber) {
                return robot;
            }
        }
        return null;
    }

    private List<Robot> searchRobotByModel(String model, List<Robot> robots) {
        List<Robot> robotsContainer = new ArrayList();
        for (Robot robot : robots) {
            if (robot.getModel().toLowerCase().trim().equals(model.trim().toLowerCase())) {
                robotsContainer.add(robot);
            }
        }

        return robotsContainer;
    }

    private int searchTotalModelAvailable(String model, List<Robot> robots) {
        int totalCount = 0;
        for (Robot robot : robots) {
            if (robot.getModel().trim().toLowerCase()
                    .equals(model.trim().toLowerCase())) {
                totalCount++;
            }
        }

        return totalCount;
    }

}
