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
    private final Scanner reader = new Scanner(System.in);

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
        System.out.println("**--DroidsRus App---------------------**");
        System.out.println("**------------------------------------**");
        System.out.println("**------------------------------------**");
        System.out.println("**------------------------------------**");
        System.out.println("**------------------------------------**");
        System.out.println("**------search features---------------**");
        System.out.println("**------------------------------------**");
        System.out.println(" 1 - Show all android v1");
        System.out.println(" 2 - Show all android v2");
        System.out.println(" 3 - Search by type");
        System.out.println(" 4 - Total count by type");
        System.out.println(" 5 - Donators");
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

        }

    }

    /**
     * Ask for total counts of available types to make the search.
     */
    private void menuTotalCounts() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Eg.: how many Andy, how many Betty etc.");
        System.out.println("Enter a model");
        String type = reader.nextLine();
        presenter.findTotalTypes(type);
    }

    /**
     * Ask for model to make the search.
     */
    private void menuSearchByType() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Eg.: Andy, mk1, Fred etc.");
        System.out.println("Enter a model");
        String model = reader.nextLine();
        presenter.findRobotByModel(model);
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
    public void printAllAndroidV1(Robot[] allV1) {
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
    public void printAllAndroidV2(Robot[] allV2) {
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
    public void showTotalCountsAvaliable(String model) {
        System.out.println(model);
        bottomMenu();
    }
}
