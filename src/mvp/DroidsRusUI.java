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

    private DroidsRusContract.BasePresenter presenter = new DroidRusPresenter();

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
        System.out.println("**--DroidsRus App---------------------**");
        System.out.println("**------------------------------------**");
        System.out.println("**------------------------------------**");
        System.out.println("**------------------------------------**");
        System.out.println("**------------------------------------**");
        System.out.println("**------search features---------------**");
        System.out.println("**------------------------------------**");
        System.out.println(" 1 - Print all android v1");
        System.out.println(" 2 - Print all android v2");
        System.out.println(" 3 - Search by model");
        System.out.println(" 4 - Total count by model");
        System.out.println(" 5 - Search all donators by model");
        System.out.println(" 6 - Search donator by Serial number");
        System.out.println(" 0 - Close app");

        int option = reader.nextInt();
        switch (option) {
            case 1:
                presenter.submitV1Androids();
                break;
            case 2:
                presenter.submitV2Androids();
                break;
            case 3:
                menuSearchByType();
                break;
            case 4:
                menuTotalCounts();
                break;
            case 5:
                menuDonated();
                break;
            case 6:
                menuDonatedById();
                break;

        }

    }

    private void menuDonated() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Eg.:Andy, Betty, Mk1, Mk2 etc.");
        System.out.println("Enter a model");
        String model = reader.nextLine();
        presenter.submitAllDonorsByModel(model);
    }

    /**
     * Ask for total counts of available types to make the search.
     */
    private void menuTotalCounts() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Eg.: how many Andy, how many Betty etc.");
        System.out.println("Enter a model");
        String type = reader.nextLine();
        presenter.submitTotalRobotByModel(type);
    }

    /**
     * Ask for model to make the search.
     */
    private void menuSearchByType() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Eg.: Andy, mk1, Fred etc.");
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
     * All available models of a particular type. (Eg. View all Fred the
     * Friendlybot models)
     *
     * @param allV1
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
        bottomMenu();
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
        bottomMenu();
    }

    @Override
    public void showDroidDonators(Robot receiver, List<Robot> donators) {

        for (Robot donator : donators) {
            System.out.println(donator.toString());
        }

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
        System.out.print("Receiver\n" + receiver.toString() + "");
        System.out.print("\n");

    }

    private void menuDonatedById() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Tips: Go to option [1] or [2] to see serial number of Android v1 or Andoid v2");
        System.out.println("Enter a serial number");
        long id = reader.nextLong();
        presenter.submitDonatorByModelId(id);
    }

}
