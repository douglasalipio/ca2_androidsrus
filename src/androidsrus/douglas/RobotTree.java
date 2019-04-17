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
public class RobotTree {

    private Node root;

    /**
     * Create a recursive method to do the insertion
     *
     * @param current
     * @param value
     * @return
     */
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
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
    public void add(int value) {
        root = addRecursive(root, value);
    }

    /**
     * Method to check if the tree contains a specific value.
     *
     * @param current
     * @param value
     * @return
     */
    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
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
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }
}
