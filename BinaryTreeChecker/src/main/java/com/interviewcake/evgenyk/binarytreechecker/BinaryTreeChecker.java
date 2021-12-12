package com.interviewcake.evgenyk.binarytreechecker;

import com.interviewcake.evgenyk.Pair;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * https://www.interviewcake.com/question/java/bst-checker
 * Created by Evgeny Kurtser on 12-Dec-21 at 10:02 AM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
public class BinaryTreeChecker {

    public static boolean isValid(BinaryTreeNode node) {
        return isValid(node, false);
    }

    public static boolean isValid(BinaryTreeNode node, boolean isFunctionalStyle) {
        if(isFunctionalStyle) {
            return node == null || isValidF(node, Pair.of(null, null));
        }
        return node == null || isValid(node, Pair.of(null, null));
    }

    /**
     * Base implementation.
     * @param node         current node
     * @param grandpaValue boundary values
     * @return <em>true</em> if the node and all its underlying nodes are "BTree valid".
     */
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



    /**
     * FP-styled implementation. <strong>It looks short but completely unreadable! Don't try to do it at home!</strong>
     * @param node         current node
     * @param grandpaValue boundary values
     * @return <em>true</em> if the node and all its underlying nodes are "BTree valid".
     */
    private static boolean isValidF(BinaryTreeNode node, Pair<Integer, Integer> grandpaValue) {
        if(traverseNodes(node, node.left, grandpaValue, Direction.LEFT)) {
            return traverseNodes(node, node.right, grandpaValue, Direction.RIGHT);
        }
        return false;
    }
    private static boolean traverseNodes(BinaryTreeNode node, BinaryTreeNode son,
                                         Pair<Integer, Integer> grandpaValue,
                                         Direction dir) {
        if(son != null) {
            if(dir.fCompareSonWithNode.apply(son.value, node.value) || (dir.fGet.apply(grandpaValue) != null && dir.fCompareSonWithGrandpa.apply(son.value, dir.fGet.apply(grandpaValue)))) {
                return false;
            }
            return isValidF(son, dir.fWith.apply(grandpaValue, node.value));
        }
        return true;
    }

    private static final BiFunction<Integer, Integer, Boolean> fGt = (a, b) -> a > b;
    private static final BiFunction<Integer, Integer, Boolean> fLt = (a, b) -> a < b;
    private static final Function<Pair<Integer, Integer>, Integer> fGetA = Pair::getA;
    private static final Function<Pair<Integer, Integer>, Integer> fGetB = Pair::getB;
    private static final BiFunction<Pair<Integer, Integer>, Integer, Pair<Integer, Integer>> fWithA = Pair::withA;
    private static final BiFunction<Pair<Integer, Integer>, Integer, Pair<Integer, Integer>> fWithB = Pair::withB;
    private enum Direction {
        LEFT(fGt, fLt, fGetA, fWithB),
        RIGHT(fLt, fGt, fGetB, fWithA);
        private final BiFunction<Integer, Integer, Boolean> fCompareSonWithNode;
        private final BiFunction<Integer, Integer, Boolean> fCompareSonWithGrandpa;
        private final Function<Pair<Integer, Integer>, Integer> fGet;
        private final BiFunction<Pair<Integer, Integer>, Integer, Pair<Integer, Integer>> fWith;
        Direction(BiFunction<Integer, Integer, Boolean> fLtGt, BiFunction<Integer, Integer, Boolean> fCompareSonWithGrandpa,
                  Function<Pair<Integer, Integer>, Integer> fGet, BiFunction<Pair<Integer, Integer>, Integer, Pair<Integer, Integer>> fWith) {
            this.fCompareSonWithNode = fLtGt;
            this.fCompareSonWithGrandpa = fCompareSonWithGrandpa;
            this.fGet = fGet;
            this.fWith = fWith;
        }
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