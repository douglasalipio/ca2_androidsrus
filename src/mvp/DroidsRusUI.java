/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp;

import entity.Robot;
import java.util.List;
import java.util.Scanner;

/**
 * The App screen.
 *
 * @author hal-9000
 */
public class DroidsRusUI implements DroidsRusContract.BaseView {

    private final DroidsRusContract.BasePresenter presenter = new DroidRusPresenter();
    private boolean hasGeneratedV1 = false;

    /**
     * Creating the APP UI.
     *
     */
    public DroidsRusUI() {
        presenter.attach(this);
    }

    /**
     * Main Menu.
     */
    public void showMainMenu() {
        Scanner reader = new Scanner(System.in);
        System.out.println(" (1) - Generate first version");
        System.out.println(" (2) - Print all android v1");
        System.out.println(" (3) - Print all android v2");
        System.out.println(" (4) - Search by model");
        System.out.println(" (5) - Total count by model");
        System.out.println(" (6) - Search donor by ID");
        System.out.println(" (0) - Close app");

        int option = reader.nextInt();

        if (option == 1 && !hasGeneratedV1) {

            presenter.submitBuildFirstVersion();

        } else if (option != 1 && hasGeneratedV1) {

            switch (option) {
                case 2:
                    presenter.submitV1Androids();
                    break;
                case 3:
                    presenter.submitV2Androids();
                    break;
                case 4:
                    menuSearchByModel();
                    break;
                case 5:
                    menuTotalCounts();
                    break;
                case 6:
                    menuDonated();
                    break;
            }
        } else {
            System.err.println("Please, generate first version!!");
            showMainMenu();
        }

    }

    /**
     * Asking for android donors model.
     */
    private void menuDonated() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Go to option [2] to see serial numbers.");
        System.out.println("Enter a serial");
        long id = reader.nextLong();
        presenter.submitDonorById(id);
    }

    /**
     * Submit total counts for second generation
     */
    private void menuTotalCounts() {
        presenter.submitTotalRobotByModel();
    }

    /**
     * Asking for model to make the search.
     */
    private void menuSearchByModel() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Eg.: Andy, Betty, Android mk1, Android mk2, etc.");
        System.out.println("Enter a model");
        String model = reader.nextLine();
        presenter.submitRobotByModel(model);
    }

    /**
     * Back Menu.
     */
    private void bottomMenu() {
        Scanner reader = new Scanner(System.in);
        System.out.println(" 1 - Back to menu");

        int option = reader.nextInt();
        if (option == 1) {
            showMainMenu();
        }
    }

    /**
     * All available models of a particular type. (Eg. View all Android mk1
     * models)
     *
     * @param allV1
     */
    @Override
    public void showAllAndroidV1(Robot[] allV1) {
        for (Robot robot : allV1) {
            System.out.println(robot.toString());
        }
        bottomMenu();
    }

    /**
     * All available models of a particular type.(Eg. View all Fred the
     * Friendlybot models)
     *
     * @param allV2
     */
    @Override
    public void showAllAndroidV2(Robot[] allV2) {
        for (Robot robot : allV2) {
            System.out.println(robot.toString());
        }
        bottomMenu();
    }

    /**
     * Showing models of a particular type.
     *
     * @param robots
     */
    @Override
    public void showRobotsByModel(List<Robot> robots) {
        for (Robot robot : robots) {
            System.out.println(robot.toString());
        }
        showMainMenu();

    }

    /**
     * Showing total counts of available types (Eg. how many Andy, how many
     * Betty... etc
     *
     * @param model
     */
    @Override
    public void showTotalRobots(String model) {
        System.out.println(model);
        showMainMenu();
    }

    /**
     * Showing android donator.
     *
     * @param receiver
     * @param donators
     */
    @Override
    public void showDroidDonators(Robot receiver, List<Robot> donators) {

        if (donators != null && !donators.isEmpty()) {
            donators.forEach((donator) -> {
                System.out.println(donator.toString());
            });

            System.out.println("-----------------------------");
            System.out.println("Parts donated");
            System.out.println("-----------------------------");
            System.out.println("Brain: " + receiver.getBrain().getValue() + " | Donator ID - " + receiver.getBrain().getKey());
            System.out.println("Mobility: " + receiver.getMobility().getValue() + "| Donator ID - " + receiver.getMobility().getKey());
            System.out.println("Vision: " + receiver.getVision().getValue() + "| Donator ID - " + receiver.getVision().getKey());
            System.out.println("Arms: " + receiver.getArms().getValue() + " | Donator ID - " + receiver.getArms().getKey());
            System.out.println("Media Center: " + receiver.getMediaCenter().getValue() + " | Donator ID - " + receiver.getMediaCenter().getKey());
            System.out.println("Power Plant: " + receiver.getPowerPlant().getValue() + " | Donator ID - " + receiver.getPowerPlant().getKey());
            System.out.println("-----------------------------");
            System.out.print("Receiver model\n" + receiver.toString() + "");
            System.out.print("\n");
        } else {
            System.out.print("Invalid model or doesn't exist.");
        }
        showMainMenu();
    }

    @Override
    public void isFirstGeneration(boolean b) {
        hasGeneratedV1 = b;
        System.err.print("Generated successfuly\n");
        showMainMenu();
    }
}
