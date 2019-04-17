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
public class Node {

    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }

}
