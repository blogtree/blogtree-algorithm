package normal;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.algorithm.structure.TreeNode;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/"></a>
 */
@Slf4j
public class No108_将有序数组转换为二叉搜索树 {

    @Test
    public void test1() {
        TreeNode tree = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：数组需要转换为 高度平衡二叉树，所以中间节点应该是数组中间的值。
     * 1 通过分治法，每次都将数组切分成 中间节点 和 左右两部分。
     * 2 直到 剩余元素个数 <= 2，表示不可再切分
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 由于java整数除法是舍弃小数点后取整，所以+1是为了每次让中间索引靠右一点
        int mid = (right + left + 1) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = buildTree(nums, left, mid - 1);
        midNode.right = buildTree(nums, mid + 1, right);
        return midNode;
    }
}
