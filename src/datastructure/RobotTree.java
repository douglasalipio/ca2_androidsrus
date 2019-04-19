/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

import datastructure.Node;
import datastructure.Node;
import mvp.Robot;
import mvp.Robot;
import mvp.Robot;

/**
 *
 * @author hal-9000
 */
public class RobotTree {

    private Node root;

    /**
     * Create a recursive method to do the insertion
     *
     * @param current
     * @param value
     * @return
     */
    public Node addRecursive(Node current, Robot value) {
        if (current == null) {
            return new Node(value);
        }

        if (value.getSerialNumber() < current.value.getSerialNumber()) {
            current.left = addRecursive(current.left, value);
        } else if (value.getSerialNumber() > current.value.getSerialNumber()) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    /**
     * Method that starts the recursion from the root node
     *
     * @param value
     */
    public void add(Robot value) {
        root = addRecursive(root, value);
    }

    /**
     * Method to check if the tree contains a specific value.
     *
     * @param current
     * @param value
     * @return
     */
    public boolean containsNodeRecursive(Node current, Robot value) {
        if (current == null) {
            return false;
        }
        if (value.getSerialNumber() == current.value.getSerialNumber()) {
            return true;
        }
        return value.getSerialNumber() < current.value.getSerialNumber()
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    /**
     * Here, we’re searching for the value by comparing it to the value in the
     * current node, then continue in the left or right child depending on that
     *
     * @param value
     * @return
     */
    public boolean containsNode(Robot value) {
        return containsNodeRecursive(root, value);
    }
    
}
