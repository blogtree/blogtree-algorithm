package normal;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.algorithm.structure.TreeNode;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-tilt/"></a>
 */
@Slf4j
public class No563_二叉树的坡度 {

    @Test
    public void test1() {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        assert 1 == findTilt(root);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public int findTilt(TreeNode root) {
        SumBox sum = new SumBox(0);
        sumTilt(root, sum);
        return sum.sum;
    }

    private void sumTilt(TreeNode root, SumBox sum) {
        if (root == null) {
            return;
        }
        SumBox leftSum = new SumBox(0);
        SumBox rightSum = new SumBox(0);
        sumTree(root.left, leftSum);
        sumTree(root.right, rightSum);
        sum.add(Math.abs(leftSum.sum - rightSum.sum));

        if (root.left != null) {
            sumTilt(root.left, sum);
        }
        if (root.right != null) {
            sumTilt(root.right, sum);
        }
    }

    private void sumTree(TreeNode root, SumBox sum) {
        if (root == null) {
            return;
        }
        sum.add(root.val);

        if (root.left != null) {
            sumTree(root.left, sum);
        }
        if (root.right != null) {
            sumTree(root.right, sum);
        }
    }

    private class SumBox {
        Integer sum;

        public SumBox(Integer sum) {
            this.sum = sum;
        }

        public void add(int addNum) {
            sum += addNum;
        }

    }
}
