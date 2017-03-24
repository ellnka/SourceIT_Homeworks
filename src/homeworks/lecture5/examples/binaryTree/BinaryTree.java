package edu.source.it.lectures.lecture5.examples.binaryTree;

public class BinaryTree {
    private BinaryTree left;
    private BinaryTree right;
    private int value;

    public BinaryTree(int value) {
        this.value = value;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }
}
