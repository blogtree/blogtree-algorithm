package summary;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.algorithm.structure.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树遍历 todo 暂未完成
 * <p>
 * 前序遍历 DLR Preorder Traversal
 * 中序遍历 LDR Inorder Traversal
 * 后序遍历 LRD Postorder Traversal
 *
 * @author AlanGeeker
 * @see <a href="https://baike.baidu.com/item/%E5%89%8D%E5%BA%8F%E9%81%8D%E5%8E%86/757319">前序遍历 - 百度百科</a>
 * @see <a href="https://baike.baidu.com/item/%E4%B8%AD%E5%BA%8F%E9%81%8D%E5%8E%86">中序遍历 - 百度百科</a>
 * @see <a href="https://baike.baidu.com/item/%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86/1214806">后序遍历 - 百度百科</a>
 */
@Slf4j
public class BinaryTreeTraversal {

    private TreeNode getBinaryTreeRoot() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);

        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node6, node7);

        TreeNode root = new TreeNode(1, node2, node3);
        return root;
    }

    /**
     * 前序遍历 DLR Preorder Traversal
     */
    @Test
    public void dlrTest() {
        List<Integer> nodeList = new LinkedList();
        dlr(getBinaryTreeRoot(), nodeList);

        log.info("dlr, nodeList={}", nodeList);
        List<Integer> checkList = Arrays.asList(1, 2, 4, 5, 3, 6, 7);
        assert checkList.equals(nodeList);
    }

    private void dlr(TreeNode node, List<Integer> nodeList) {
        Stack<Integer> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node!=null){
                nodeList.add(node.val);

            }
            if (node.left != null) {
                nodeList.add(node.left.val);
            }
        }
    }

    /**
     * 中序遍历 LDR Inorder Traversal
     */
    @Test
    public void ldrByRecursionTest() {
        List<Integer> nodeList = new LinkedList();
        ldrByRecursion(getBinaryTreeRoot(), nodeList);

        log.info("ldrByRecursion, nodeList={}", nodeList);
        List<Integer> checkList = Arrays.asList(4, 2, 5, 1, 6, 3, 7);
        assert checkList.equals(nodeList);
    }

    private void ldrByRecursion(TreeNode node, List<Integer> nodeList) {
        if (node != null) {
            ldrByRecursion(node.left, nodeList);
            nodeList.add(node.val);
            ldrByRecursion(node.right, nodeList);
        }
    }

    /**
     * 后序遍历 LRD Postorder Traversal
     */
    @Test
    public void lrdByRecursionTest() {
        List<Integer> nodeList = new LinkedList();
        lrdByRecursion(getBinaryTreeRoot(), nodeList);

        log.info("lrdByRecursion, nodeList={}", nodeList);
        List<Integer> checkList = Arrays.asList(4, 2, 5, 6, 3, 7, 1);
        assert checkList.equals(nodeList);
    }

    private void lrdByRecursion(TreeNode node, List<Integer> nodeList) {
        if (node != null) {
            ldrByRecursion(node.left, nodeList);
            ldrByRecursion(node.right, nodeList);
            nodeList.add(node.val);
        }
    }
}
