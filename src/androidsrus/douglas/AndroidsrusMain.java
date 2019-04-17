/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package androidsrus.douglas;

/**
 *
 * @author hal-9000
 */
public class AndroidsrusMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RobotTree robotTree = createBinaryTree();
        if (robotTree.containsNode(10)) {
            System.out.println("there is a value ");
        } else {
            System.out.println("there is no value");
        }
    }

    private static RobotTree createBinaryTree() {
        RobotTree bt = new RobotTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        return bt;
    }
}
