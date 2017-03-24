package edu.source.it.lectures.lecture5.examples.binaryTree;

import edu.source.it.lectures.lecture5.examples.binaryTree.BinaryTree;

public class TreeUtils {

    public static int getDepth(BinaryTree tree) {
        int leftDepth = 0;
        int rightDepth = 0;
        if (tree.getLeft() != null) {
            leftDepth = getDepth(tree.getLeft());
        }
        if (tree.getRight() != null) {
            rightDepth = getDepth(tree.getRight());
        }
        return Math.max(leftDepth + 1, rightDepth + 1);
    }
}
