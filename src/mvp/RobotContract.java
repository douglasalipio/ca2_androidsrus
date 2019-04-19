/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp;

import java.util.List;

/**
 *
 * @author hal-9000
 */
public interface RobotContract {

    public interface BaseView {

        public void showFirstGeneration(List<Robot> robots);
    }

    public interface BasePresenter {

        public void attach(RobotContract.BaseView view);

        public void generateFirstGeneration();
    }

}
