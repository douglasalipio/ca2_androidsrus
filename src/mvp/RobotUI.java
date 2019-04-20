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
 *
 * @author hal-9000
 */
public class RobotUI implements RobotContract.BaseView {

    private RobotContract.BasePresenter presenter = new RobotPresenter();
    private final Scanner reader = new Scanner(System.in);

    public RobotUI() {
        presenter.attach(this);
    }

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

    private void menuTotalCounts() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Eg.: how many Andy, how many Betty etc.");
        System.out.println("Enter a model");
        String type = reader.nextLine();
        presenter.findTotalTypes(type);
    }

    private void menuSearchByType() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Eg.: Andy, mk1, Fred etc.");
        System.out.println("Enter a model");
        String model = reader.nextLine();
        presenter.findRobotByModel(model);
    }

    private void bottomMenu() {
        Scanner reader = new Scanner(System.in);
        System.out.println(" 1 - Back to menu");

        int option = reader.nextInt();
        if (option == 1) {
            showMainMenu();
        }
    }

    @Override
    public void printAllAndroidV1(Robot[] allV1) {
        for (Robot robot : allV1) {
            System.out.println(robot.toString());
        }
        bottomMenu();
    }

    @Override
    public void printAllAndroidV2(Robot[] allV2) {
        for (Robot robot : allV2) {
            System.out.println(robot.toString());
        }
        bottomMenu();
    }

    @Override
    public void showRobotsByModel(List<Robot> robots) {
        for (Robot robot : robots) {
            System.out.println(robot.toString());
        }
        bottomMenu();
    }

    @Override
    public void showTotalCountsAvaliable(String model) {
        System.out.println(model);
        bottomMenu();
    }

    @Override
    public void onErrorEmptylist() {
        System.err.println("\nEmpty list. Please build first/second"
                + " generation on Menu Option (1) and (2) \n");
        bottomMenu();
    }
}
