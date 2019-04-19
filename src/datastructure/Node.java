/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

import mvp.Robot;

/**
 *
 * @author hal-9000
 */
public class Node {

    public Robot value;
    public Node left;
    public Node right;

    public Node(Robot robot) {
        this.value = robot;
        this.right = null;
        this.left = null;
    }

}
