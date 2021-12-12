package com.interviewcake.evgenyk.binarytreechecker;

import com.interviewcake.evgenyk.Pair;

/**
 * https://www.interviewcake.com/question/java/bst-checker
 * Created by Evgeny Kurtser on 12-Dec-21 at 10:02 AM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
public class BinaryTreeChecker {

    public static boolean isValid(BinaryTreeNode node) {
        return node == null || isValid(node, Pair.of(null, null));
    }

    private static boolean isValid(BinaryTreeNode node, Pair<Integer, Integer> grandpaValue) {
        boolean res = true;
        if(node.left != null) {
            if(node.left.value > node.value || (grandpaValue.getA() != null && node.left.value < grandpaValue.getA())) {
                return false;
            }
            res = isValid(node.left, grandpaValue.withB(node.value));
        }
        if(res) {
            if(node.right != null) {
                if(node.right.value < node.value || (grandpaValue.getB() != null && node.right.value > grandpaValue.getB())) {
                    return false;
                }
                res = isValid(node.right, grandpaValue.withA(node.value));
            }
        }
        return res;
    }
}

class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertLeft(int leftValue) {
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }

    @Override
    public String toString() {
        return (left == null ? "-" : left.value) + "<-[" + value + "]->" + (right == null ? "-" : right.value);
    }
}