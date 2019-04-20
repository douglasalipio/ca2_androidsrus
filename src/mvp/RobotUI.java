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

    @Override
    public void showFirstGeneration(Robot[] robots) {
        for (Robot robot : robots) {
            System.out.println(robot.toString());
        }
        bottomMenu();
    }

    @Override
    public void showSecondGeneration(Robot[] robots) {
        for (Robot robot : robots) {
            System.out.println(robot.toString());
        }
        bottomMenu();
    }

    public void showMainMenu() {

        System.out.println("**--DroidsRus App---------------------**");
        System.out.println("**------------------------------------**");
        System.out.println("**------------------------------------**");
        System.out.println("**-----------Build features-----------**");
        System.out.println("**------------------------------------**");
        System.out.println(" 1 - Generate first version");
        System.out.println(" 2 - Generate second version");
        System.out.println("**------------------------------------**");
        System.out.println("**------search features---------------**");
        System.out.println("**------------------------------------**");
        System.out.println(" 3 - Show all android v1");
        System.out.println(" 4 - Show all android v2");
        System.out.println(" 5 - Search by type");
        System.out.println(" 6 - Total count by type");
        System.out.println(" 7 - Donators");
        System.out.println(" 0 - Close app");

        int option = reader.nextInt();
        switch (option) {
            case 1:
                presenter.generateFirstGeneration();
                break;
            case 2:
                presenter.generateSecondGeneration();
                break;
            case 3:
                presenter.submitV1Androids();
                break;
            case 4:
                presenter.submitV2Androids();
                break;
        }

    }

    private void bottomMenu() {

        System.out.println(" 1 - Back to menu");
        System.out.println(" 2 - Close app");

        int option = reader.nextInt();
        switch (option) {
            case 1:
                showMainMenu();
                break;
            case 2:
                break;
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
    public void onEmptyV1AndroidList() {
        System.out.println("\nEmpty list. Please build first "
                + "generation on Menu Option (1)\n");
        bottomMenu();
    }

    @Override
    public void onEmptyV2AndroidList() {
        System.out.println("\nEmpty list. Please build second"
                + " generation on Menu Option (2)\n");
        bottomMenu();
    }

}
