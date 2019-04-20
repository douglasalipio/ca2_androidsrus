/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp;

import entity.Robot;
import java.util.List;

/**
 *
 * @author hal-9000
 */
public interface RobotContract {

    public interface BaseView {

        public void showFirstGeneration(Robot[] robots);
        
        public void showSecondGeneration(Robot[] robots);

        public void printAllAndroidV1(Robot[] allV1);

        public void printAllAndroidV2(Robot[] allV2);

        public void onEmptyV1AndroidList();

        public void onEmptyV2AndroidList();
    }

    public interface BasePresenter {

        public void attach(RobotContract.BaseView view);

        public void generateFirstGeneration();
        
        public void generateSecondGeneration();

        public void submitV1Androids();

        public void submitV2Androids();
    }

}
