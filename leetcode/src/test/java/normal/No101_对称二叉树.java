package normal;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.algorithm.structure.TreeNode;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.cn/problems/symmetric-tree/?favorite=2cktkvj"></a>
 */
@Slf4j
public class No101_对称二叉树 {

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：树 深度优先搜索 广度优先搜索 二叉树 递归
     * 分析：
     * 1 左侧节点 等级 右侧节点
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
