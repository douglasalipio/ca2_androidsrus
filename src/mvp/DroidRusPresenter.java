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
import java.util.stream.Collectors;

/**
 * Controlling the logic of DroidsRus.
 *
 * @author hal-9000
 */
public class DroidRusPresenter implements DroidsRusContract.BasePresenter {

    private final RobotBuilder robotBuilder = RobotBuilder.instance();
    private DroidsRusContract.BaseView view;
    private final List<Robot> robots = robotBuilder.allAndroids();

    /**
     * Dependency injection from view.
     *
     * @param view
     */
    @Override
    public void attach(DroidsRusContract.BaseView view) {
        this.view = view;
    }

    /**
     * Send to view all android v1.
     */
    @Override
    public void submitV1Androids() {
        view.showAllAndroidV1(robotBuilder.allV1Androids());
    }

    /**
     * Send to view all android v2.
     */
    @Override
    public void submitV2Androids() {
        view.showAllAndroidV2(robotBuilder.allV2Androids());
    }

    /**
     * Validating if exist robots with a specific model.
     *
     * @param model filter of the search.
     */
    @Override
    public void submitRobotByModel(String model) {
        view.showRobotsByModel(findRobotByModel(model, robots));

    }

    /**
     * Retrieving the number of androids in stock by model.
     *
     */
    @Override
    public void submitTotalRobotByModel() {
        int totalAndy = robots
                .stream()
                .filter((robot) -> (robot.getModel().equals("Andy")))
                .toArray().length;

        int totalBetty = robots
                .stream()
                .filter((robot) -> (robot.getModel().equals("Betty")))
                .toArray().length;

        int totalBobi = robots
                .stream()
                .filter((robot) -> (robot.getModel().equals("Bobi")))
                .toArray().length;

        int totalFred = robots
                .stream()
                .filter((robot) -> (robot.getModel().equals("Fred")))
                .toArray().length;

        String label = "Total count Andy is " + totalAndy + "\n";
        label += "Total count Betty is " + totalBetty + "\n";
        label += "Total count Bobi is " + totalBobi + "\n";
        label += "Total count Fred is " + totalFred + "\n";

        view.showTotalRobots(label);
    }

    /**
     * Retrieving all donors of all models.
     *
     * @param id serial .
     */
    @Override
    public void submitDonorById(long id) {
        var robotId = findRobotById(id);
        if (robotId != -1) {
            var receiver = robots.get(robotId);
            view.showDroidDonators(receiver, findDonorComponents(receiver));
        }

    }

    /**
     * Retrieving all donors of an android
     *
     * @param receiver Android who wants to know his donors.
     * @return a list of donors.
     */
    private List<Robot> findDonorComponents(Robot receiver) {
        List<Robot> robotContainer = new ArrayList();
        robotContainer.add(robots.get(findRobotById(receiver.getBrain().getKey())));
        robotContainer.add(robots.get(findRobotById(receiver.getMobility().getKey())));
        robotContainer.add(robots.get(findRobotById(receiver.getVision().getKey())));
        robotContainer.add(robots.get(findRobotById(receiver.getArms().getKey())));
        robotContainer.add(robots.get(findRobotById(receiver.getMediaCenter().getKey())));
        robotContainer.add(robots.get(findRobotById(receiver.getPowerPlant().getKey())));
        return robotContainer;
    }

    /**
     * Retrieving android by id.
     *
     * @param key the serial number of the android.
     * @return index in list.
     */
    public int findRobotById(long key) {
        int index = -1;
        int low = 0;
        int high = robots.size();
        while (low <= high) {
            int mid = (low + high) / 2;
            if (robots.get(mid).getSerialNumber() < key) {
                low = mid + 1;
            } else if (robots.get(mid).getSerialNumber() > key) {
                high = mid - 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;
    }
  

    /**
     * Retrieving android by model.
     *
     * @param model find by model
     * @return robot found.
     */
    private List<Robot> findRobotByModel(String model, List<Robot> robots) {
        return robots
                .stream()
                .filter((robot) -> (normalize(robot.getModel()).equals(normalize(model))))
                .collect(Collectors.toList());
    }

    /**
     * Making the user's input normalized Eg: from "Hey there" to "hey there"
     *
     * @param value input
     * @return string normalized
     */
    private String normalize(String value) {
        return value.trim().toLowerCase();
    }

}
