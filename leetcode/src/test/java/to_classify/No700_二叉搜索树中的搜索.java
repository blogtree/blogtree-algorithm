package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.algorithm.structure.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @see <a href="https://leetcode-cn.com/problems/search-in-a-binary-search-tree/"></a>
 */
@Slf4j
public class No700_二叉搜索树中的搜索 {

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public TreeNode searchBST(TreeNode root, int val) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                if (root.val == val) {
                    return root;
                }
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        return null;
    }
}