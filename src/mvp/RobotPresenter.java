/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp;

import builder.RobotBuilder;
import entity.Robot;
import java.util.List;

/**
 *
 * @author hal-9000
 */
public class RobotPresenter implements RobotContract.BasePresenter {

    private RobotBuilder robotBuilder = RobotBuilder.instance();
    private RobotContract.BaseView view;

    @Override
    public void attach(RobotContract.BaseView view) {
        this.view = view;
    }

    @Override
    public void generateFirstGeneration() {
        if (view != null) {
            view.showFirstGeneration(robotBuilder.v1Bunch());
        } else {
            errorMessage("Fail to generate robosts");
        }
    }

    @Override
    public void generateSecondGeneration() {

        if (view != null) {
            view.showSecondGeneration(robotBuilder.v2Bunch());
        } else {
            errorMessage("Fail to generate robosts");
        }
    }

    private void errorMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void submitV1Androids() {
        Robot[] allV1 = robotBuilder.allV1Androids();
        if (allV1 != null) {
            view.printAllAndroidV1(allV1);
        } else {
            view.onEmptyV1AndroidList();
        }
    }

    @Override
    public void submitV2Androids() {
        Robot[] allV2 = robotBuilder.allV2Androids();
        if (allV2 != null) {
            view.printAllAndroidV2(allV2);
        } else {
            view.onEmptyV2AndroidList();
        }
    }
}
