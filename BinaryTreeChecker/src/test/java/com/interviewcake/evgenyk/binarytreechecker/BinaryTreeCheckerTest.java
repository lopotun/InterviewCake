package com.interviewcake.evgenyk.binarytreechecker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Evgeny Kurtser on 12-Dec-21 at 10:45 AM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
class BinaryTreeCheckerTest {


    @Test
    void isValidNull() {
        assertTrue(BinaryTreeChecker.isValid(null));
    }

    @Test
    void isValidOne() {
        BinaryTreeNode x = new BinaryTreeNode(42);
        assertTrue(BinaryTreeChecker.isValid(x));
    }

    @Test
    void isValidTwo() {
        BinaryTreeNode x = new BinaryTreeNode(42);
        x.insertLeft(17);
        assertTrue(BinaryTreeChecker.isValid(x));
    }

    @Test
    void isValid3L0R() {
        BinaryTreeNode x = new BinaryTreeNode(42);
        x.insertLeft(17).insertLeft(15);
        assertTrue(BinaryTreeChecker.isValid(x));
    }

    /**
     * <img src="doc-files/bst_checker__parent_check_insufficient.svg" alt="Foo">
     */
    @Test
    void invalid01() {
        // Level 0
        BinaryTreeNode level0 = new BinaryTreeNode(50);

        BinaryTreeNode level1L = level0.insertLeft(30);
        level1L.insertLeft(20);
        level1L.insertRight(60);

        BinaryTreeNode level1R = level0.insertRight(80);
        level1R.insertLeft(70);
        level1R.insertRight(90);

        assertFalse(BinaryTreeChecker.isValid(level0));
    }


    /**
     * <img src="doc-files/bst_checker_bad_40.png" alt="Foo">
     */
    @Test
    void invalidBad40() {
        BinaryTreeNode level0 = new BinaryTreeNode(50);

        BinaryTreeNode level1L = level0.insertLeft(30);
        level1L.insertLeft(20);

        BinaryTreeNode level1R = level0.insertRight(80);
        level1R.insertLeft(40);

        assertFalse(BinaryTreeChecker.isValid(level0));
    }

    /**
     * <img src="doc-files/bst_checker_bad_50.png" alt="Foo">
     */
    @Test
    void invalidBad50() {
        BinaryTreeNode level0 = new BinaryTreeNode(50);

        BinaryTreeNode level1L = level0.insertLeft(30);
        BinaryTreeNode level2L = level1L.insertLeft(20);
        level2L.insertRight(50);
        level0.insertRight(80);

        assertFalse(BinaryTreeChecker.isValid(level0));
    }

    /**
     * <img src="doc-files/bst_checker_bad_60.png" alt="Foo">
     */
    @Test
    void invalidBad60() {
        BinaryTreeNode level0 = new BinaryTreeNode(50);

        BinaryTreeNode level1L = level0.insertLeft(30);
        BinaryTreeNode level2L = level1L.insertLeft(20);
        level2L.insertRight(60);
        level0.insertRight(80);

        assertFalse(BinaryTreeChecker.isValid(level0));
    }

    /**
     * <img src="doc-files/bst_checker_bad_90.png" alt="Foo">
     */
    @Test
    void invalidBad90() {
        BinaryTreeNode level0 = new BinaryTreeNode(50);
        level0.insertLeft(30);
        BinaryTreeNode level1R = level0.insertRight(80);
        BinaryTreeNode level2L = level1R.insertLeft(70);
        level2L.insertRight(90);

        assertFalse(BinaryTreeChecker.isValid(level0));
    }

    /**
     * <img src="doc-files/bst_checker_bad_20.png" alt="Foo">
     */
    @Test
    void invalidBad20() {
        BinaryTreeNode x = new BinaryTreeNode(42);
        x.insertLeft(17).insertLeft(15);
        x.insertRight(20);
        assertFalse(BinaryTreeChecker.isValid(x));
    }

    @Test
    void isValid4L1R() {
        BinaryTreeNode x = new BinaryTreeNode(42);
        x.insertLeft(17).insertLeft(15).insertLeft(10);
        x.insertRight(20);
        assertFalse(BinaryTreeChecker.isValid(x));
    }

    @Test
    void isValidX() {
        BinaryTreeNode x = new BinaryTreeNode(42);
        x.insertLeft(17).insertLeft(15).insertLeft(10).insertRight(5);
        x.insertRight(20).insertLeft(22);
        x.right.insertRight(23);
        assertFalse(BinaryTreeChecker.isValid(x));
    }
}