/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp;

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
    public void showFirstGeneration(List<Robot> robots) {
        for (Robot robot : robots) {
            System.out.println(robot.toString());
        }
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
                break;
            case 3:
                break;
            case 4:
                break;
        }

    }

}
