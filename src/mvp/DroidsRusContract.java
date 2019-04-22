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

        public void showAllAndroidV1(Robot[] allV1);

        public void showAllAndroidV2(Robot[] allV2);

        public void showRobotsByModel(List<Robot> searchRobotByModel);

        public void showTotalRobots(String model);

        public void showDroidDonators(Robot receiver, List<Robot> donators);

    }

    public interface BasePresenter {

        public void attach(DroidsRusContract.BaseView view);

        public void submitV1Androids();

        public void submitV2Androids();

        public void submitRobotByModel(String model);

        public void submitTotalRobotByModel(String model);

        public void submitAllDonorsByModel(String model);

        public void submitDonatorByModelId(long id);
    }

}
