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
public interface DroidsRusContract {

    public interface BaseView {

        public void printAllAndroidV1(Robot[] allV1);

        public void printAllAndroidV2(Robot[] allV2);

        public void showRobotsByModel(List<Robot> searchRobotByModel);

        public void showTotalCountsAvaliable(String model);

        public void showDroidDonators(Robot receiver, List<Robot> donators);

    }

    public interface BasePresenter {

        public void attach(DroidsRusContract.BaseView view);

        public void submitV1Androids();

        public void submitV2Androids();

        public void findRobotByModel(String model);

        public void findTotalTypes(String model);

        public void findDRoidDonatiors(String model);
    }

}
