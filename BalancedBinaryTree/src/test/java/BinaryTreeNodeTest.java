import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Evgeny Kurtser on 09-Dec-21 at 8:17 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
class BinaryTreeNodeTest {

    @Test
    void isSuperBalancedNull() {
        assertTrue(BinaryTreeNode.isSuperBalanced(null));
    }

    @Test
    void isSuperBalancedOne() {
        BinaryTreeNode x = new BinaryTreeNode(42);
        assertTrue(BinaryTreeNode.isSuperBalanced(x));
    }

    @Test
    void isSuperBalancedTwo() {
        BinaryTreeNode x = new BinaryTreeNode(42);
        x.insertLeft(17);
        assertTrue(BinaryTreeNode.isSuperBalanced(x));
    }

    @Test
    void isSuperBalanced3L0R() {
        BinaryTreeNode x = new BinaryTreeNode(42);
        x.insertLeft(17).insertLeft(15);
        assertTrue(BinaryTreeNode.isSuperBalanced(x));
    }

    @Test
    void isSuperBalanced3L1R() {
        BinaryTreeNode x = new BinaryTreeNode(42);
        x.insertLeft(17).insertLeft(15);
        x.insertRight(20);
        assertTrue(BinaryTreeNode.isSuperBalanced(x));
    }

    @Test
    void isSuperBalanced4L1R() {
        BinaryTreeNode x = new BinaryTreeNode(42);
        x.insertLeft(17).insertLeft(15).insertLeft(10);
        x.insertRight(20);
        assertFalse(BinaryTreeNode.isSuperBalanced(x));
    }

    @Test
    void isSuperBalancedX() {
        BinaryTreeNode x = new BinaryTreeNode(42);
        x.insertLeft(17).insertLeft(15).insertLeft(10).insertRight(5);
        x.insertRight(20).insertLeft(22);
        x.right.insertRight(23);
        assertFalse(BinaryTreeNode.isSuperBalanced(x));
    }
}