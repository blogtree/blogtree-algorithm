package normal;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.algorithm.structure.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode-cn.com/problems/linked-list-cycle/"></a>
 */
@Slf4j
public class No141_环形链表 {

    @Test
    public void test1() {
        ListNode head = ListNode.buildList(new int[]{1, 2, 3});
        assert !hasCycle(head);
    }

    @Test
    public void test2() {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        node3.next = node2;

        assert hasCycle(node1);
    }

    @Test
    public void test3() {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        node3.next = node1;

        assert hasCycle(node1);
    }

    @Test
    public void test4() {
        assert !hasCycle(null);
        assert !hasCycle(new ListNode(1, null));
    }

    /**
     * 分析：
     * 1 从头开始遍历联表，先将当前节点存到set中
     * 2 再判断next节点是否存在set中，如果存在，则表示存在环，返回true
     * 3 如果遍历结束（next == null），则表示不存在环，返回false
     * <p>
     * 题解
     * 方法一：哈希表  时间复杂度：O(N) 空间复杂度：O(N)
     * 方法二：快慢指针 时间复杂度：O(N) 空间复杂度：O(1)
     */
    public boolean hasCycle(ListNode head) {
        // 边界校验
        if (head == null || head.next == null) {
            return false;
        }

        Set<ListNode> set = new HashSet();

        while (head.next != null) {
            set.add(head);
            if (set.contains(head.next)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
