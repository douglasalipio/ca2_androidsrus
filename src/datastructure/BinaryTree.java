/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

/**
 *
 * @author hal-9000
 */
public class BinaryTree {

    private Object value;
    private BinaryTree leftChild;
    private BinaryTree rightChild;

    /**
     * Constructor for BinaryTree.
     *
     * @param value The value to be placed in the root.
     * @param leftChild The left child of the root (may be null).
     * @param rightChild The right child of the root (may be null).
     */
    public BinaryTree(Object value,
            BinaryTree leftChild,
            BinaryTree rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * Constructor for a BinaryTree leaf node (that is, with no children).
     *
     * @param value The value to be placed in the root.
     */
    public BinaryTree(Object value) {
        this(value, null, null);
    }

    /**
     * Getter method for left child of this BinaryTree node.
     *
     * @return The left child.
     */
    public BinaryTree getLeftChild() {
        return leftChild;
    }

    /**
     * Getter method for right child of this BinaryTree node.
     *
     * @return The right child.
     */
    public BinaryTree getRightChild() {
        return rightChild;
    }

    /**
     * Sets the left child of this BinaryTree node to be the given subtree. If
     * the node previously had a left child, it is discarded. Throws an
     * <code>IllegalArgumentException</code> if the operation would cause a loop
     * in the binary tree.
     *
     * @param subtree The node to be added as the new left child.
     * @throws IllegalArgumentException If the operation would cause a loop in
     * the binary tree.
     */
    public void setLeftChild(BinaryTree subtree)
            throws IllegalArgumentException {
        if (contains(subtree, this)) {
            throw new IllegalArgumentException(
                    "Subtree " + this + " already contains " + subtree);
        }
        leftChild = subtree;
    }

    /**
     * Sets the right child of this BinaryTree node to be the given subtree. If
     * the node previously had a right child, it is discarded. Throws an
     * <code>IllegalArgumentException</code> if the operation would cause a loop
     * in the binary tree.
     *
     * @param subtree The node to be added as the new right child.
     * @throws IllegalArgumentException If the operation would cause a loop in
     * the binary tree.
     */
    public void setRightChild(BinaryTree subtree)
            throws IllegalArgumentException {
        if (contains(subtree, this)) {
            throw new IllegalArgumentException("Subtree " + this
                    + " already contains " + subtree);
        }
        rightChild = subtree;
    }

    /**
     * Tests whether this node is a leaf node.
     *
     * @return <code>true</code> if this BinaryTree node has no children.
     */
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    /**
     * Tests whether this BinaryTree is equal to the given object. To be
     * considered equal, the object must be a BinaryTree, and the two binary
     * trees must have equal values in their roots, equal left subtrees, and
     * equal right subtrees.
     *
     * @return <code>true</code> if the binary trees are equal.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof BinaryTree)) {
            return false;
        }
        BinaryTree otherTree = (BinaryTree) o;
        return equals(value, otherTree.value)
                && equals(leftChild, otherTree.getLeftChild())
                && equals(rightChild, otherTree.getRightChild());
    }

    /**
     * Tests whether its two arguments are equal. This method simply checks for
     * <code>null</code> before calling <code>equals(Object)</code> so as to
     * avoid possible <code>NullPointerException</code>s.
     *
     * @param x The first object to be tested.
     * @param y The second object to be tested.
     * @return <code>true</code> if the two objects are equal.
     */
    private boolean equals(Object x, Object y) {
        if (x == null) {
            return y == null;
        }
        return x.equals(y);
    }

    /**
     * Tests whether the <code>tree</code> argument contains within itself the
     * <code>targetNode</code> argument.
     *
     * @param tree The root of the binary tree to search.
     * @param targetNode The node to be searched for.
     * @return <code>true</code> if the <code>targetNode</code> argument can be
     * found within the binary tree rooted at <code>tree</code>.
     */
    protected boolean contains(BinaryTree tree, BinaryTree targetNode) {
        if (tree == null) {
            return false;
        }
        if (tree == targetNode) {
            return true;
        }
        return contains(targetNode, tree.getLeftChild())
                || contains(targetNode, tree.getRightChild());
    }

    /**
     * Returns a String representation of this BinaryTree.
     *
     * @see java.lang.Object#toString()
     * @return A String representation of this BinaryTree.
     */
    @Override
    public String toString() {
        if (isLeaf()) {
            return value.toString();
        } else {
            String root, left = "-", right = "-";
            root = value.toString();
            if (getLeftChild() != null) {
                left = getLeftChild().toString();
            }
            if (getRightChild() != null) {
                right = getRightChild().toString();
            }
            return root + "(" + left + ", " + right + ")";
        }
    }

    /**
     * Tests the toString() method.
     *
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree root, left, right;
        left = new BinaryTree("D");
        left = new BinaryTree("B", left, null);
        right = new BinaryTree("E");
        right = new BinaryTree("C", null, right);
        root = new BinaryTree("A", left, right);
        System.out.println(root);
    }

    /**
     * Returns the value in this node.
     *
     * @return The value stored in this BinaryTree node.
     */
    public Object getValue() {
        return value;
    }

    /**
     * Sets the value in this node.
     *
     * @param value The value to store in this BinaryTree node.
     */
    public void setValue(Object value) {
        this.value = value;
    }
}
