package edu.source.it.lectures.lecture5.examples.binaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        BinaryTree left = new BinaryTree(2);
        BinaryTree right = new BinaryTree(3);
        tree.setLeft(left);
        tree.setRight(right);
        left.setLeft(new BinaryTree(4));
        left.setRight(new BinaryTree(5));
        right.setLeft(new BinaryTree(6));
        right.setRight(new BinaryTree(7));
        right.getRight().setLeft(new BinaryTree(6));

        System.out.println("Tree depth is " + TreeUtils.getDepth(tree));
    }
}
