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
 * Interface for droids.
 *
 * @author hal-9000
 */
public interface DroidsRusContract {

    /**
     * Base view.
     */
    public interface BaseView {

        /**
         * Showing all android v1
         *
         * @param allV1
         */
        public void showAllAndroidV1(Robot[] allV1);

        /**
         * Showing all android v2
         *
         * @param allV2
         */
        public void showAllAndroidV2(Robot[] allV2);

        /**
         * Showing all robots by model.
         *
         * @param searchRobotByModel
         */
        public void showRobotsByModel(List<Robot> searchRobotByModel);

        /**
         * Total robots by model
         *
         * @param model
         */
        public void showTotalRobots(String model);

        /**
         * Showing donor.
         *
         * @param receiver
         * @param donators
         */
        public void showDroidDonators(Robot receiver, List<Robot> donators);

    }

    public interface BasePresenter {

        /**
         * Injecting view.
         *
         * @param view
         */
        public void attach(DroidsRusContract.BaseView view);

        /**
         * Submit v1 androids.
         *
         */
        public void submitV1Androids();

        /**
         * Submit v2 android.
         */
        public void submitV2Androids();

        /**
         * Submit robot by model
         *
         * @param model
         */
        public void submitRobotByModel(String model);

        /**
         * Submit total robot by model
         */
        public void submitTotalRobotByModel();

        /**
         * Submit all donor by id
         *
         * @param id serial number
         */
        public void submitDonorById(long id);
    }

}
