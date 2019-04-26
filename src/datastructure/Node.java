/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

import entity.Robot;

/**
 *
 * @author hal-9000
 */
public class Node {

    Robot value;
    Node left;
    Node right;

    Node(Robot value) {
        this.value = value;
        right = null;
        left = null;
    }
}
