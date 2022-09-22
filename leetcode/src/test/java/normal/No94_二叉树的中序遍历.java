package normal;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.algorithm.structure.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-inorder-traversal/"></a>
 */
@Slf4j
public class No94_二叉树的中序遍历 {

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
     * 1 创建List存储结果
     * 2 通过递归遍历root节点，并依次存储到list中
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        ldr(root, list);
        return list;
    }

    private void ldr(TreeNode root, List<Integer> list) {
        if (root != null) {
            ldr(root.left, list);
            list.add(root.val);
            ldr(root.right, list);
        }
    }
}
