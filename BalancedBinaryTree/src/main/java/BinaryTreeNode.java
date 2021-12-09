import com.interviewcake.evgenyk.Pair;

/**
 * https://www.interviewcake.com/question/java/balanced-binary-tree
 * Created by Evgeny Kurtser on 09-Dec-21 at 8:00 PM.
 * <a href=mailto:EvgenyK@traiana.com>EvgenyK@traiana.com</a>
 */
public class BinaryTreeNode {

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


    /**
     * Checks if a binary tree is "superbalanced".
     * @param node the node
     * @return <em>true</em> if the given node is <em>null</em> or if the difference between the depths of any two leaf nodes is no greater than one.
     */
    public static boolean isSuperBalanced(BinaryTreeNode node) {
        Pair<Integer, Integer> minmax = Pair.of(Integer.MAX_VALUE, Integer.MIN_VALUE);
        return isSuperBalanced(node, 0, minmax);
    }

    private static boolean isSuperBalanced(BinaryTreeNode node, int level, Pair<Integer, Integer> minmax) {
        if(node == null) {
            return true;
        }
        level++;
        boolean res;
        if(node.left == null && node.right == null) { // this is the leaf node.
            res = checkMinMax(level, minmax); // check if the current level is within the known min-max boundaries.
        } else { // this is not leaf node
            res = isSuperBalanced(node.left, level, minmax); // check its left son.
            res = res && isSuperBalanced(node.right, level, minmax); // check its right son (if and only if its left side is still OK).
        }
        return res;
    }

    /**
     * Checks if the given level
     * @param level current B-tree level
     * @param minmax contains min-max pair
     * @return <em>true</em> if the given level is not less than min-1 <strong>and</strong> not greater than max+1.
     */
    private static boolean checkMinMax(int level, Pair<Integer, Integer> minmax) {
        minmax.setA(Math.min(minmax.getA(), level));
        minmax.setB(Math.max(minmax.getB(), level));
        return minmax.getB() - minmax.getA() < 2;
    }
}