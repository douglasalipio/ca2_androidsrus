/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp;

import builder.RobotBuilder;
import mvp.Robot;
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
        }
    }

}
