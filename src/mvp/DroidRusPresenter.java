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
        if (robots != null) {
            view.showRobotsByModel(findRobotByModel(model));
        }

    }

    /**
     * Retrieving the number of androids in stock by model.
     *
     * @param model filter of the search.
     */
    @Override
    public void submitTotalRobotByModel(String model) {
        int totalCount = robots
                .stream()
                .filter((robot) -> (normalize(robot.getModel()).equals(normalize(model))))
                .toArray().length;

        view.showTotalRobots("Total count for " + model + " is " + totalCount);

    }

    /**
     * Retrieving all donors of all models.
     *
     * @param model filter of the search.
     */
    @Override
    public void submitAllDonorsByModel(String model) {
        findRobotByModel(model).forEach((droidReceiver) -> {
            view.showDroidDonators(droidReceiver, findDonorComponents(droidReceiver));
        });
    }

    /**
     * Retrieving donor of a model by id.
     *
     * @param id
     */
    @Override
    public void submitDonatorByModelId(long id) {
        Robot receiver = findRobotById(id);
        view.showDroidDonators(receiver, findDonorComponents(receiver));
    }

    /**
     * Retrieving all donors of an android
     *
     * @param receiver Android who wants to know his donors.
     * @return a list of donors.
     */
    private List<Robot> findDonorComponents(Robot receiver) {
        List<Robot> robotContainer = new ArrayList();
        robotContainer.add(findRobotById(receiver.getBrain().getKey()));
        robotContainer.add(findRobotById(receiver.getMobility().getKey()));
        robotContainer.add(findRobotById(receiver.getVision().getKey()));
        robotContainer.add(findRobotById(receiver.getArms().getKey()));
        robotContainer.add(findRobotById(receiver.getMediaCenter().getKey()));
        robotContainer.add(findRobotById(receiver.getPowerPlant().getKey()));
        return robotContainer;
    }

    /**
     * Retrieving android by id.
     *
     * @param id the serial number of the android.
     * @return robot found.
     */
    private Robot findRobotById(long id) {
        return robots
                .stream()
                .filter((robot) -> (robot.getSerialNumber() == id))
                .findAny()
                .orElse(null);
    }

    /**
     * Retrieving android by model.
     *
     * @param model find by model
     * @return robot found.
     */
    private List<Robot> findRobotByModel(String model) {
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
        return value.toLowerCase();
    }

}
