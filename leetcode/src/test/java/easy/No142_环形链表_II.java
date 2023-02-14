package easy;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.algorithm.structure.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode-cn.com/problems/linked-list-cycle-ii/"></a>
 */
@Slf4j
public class No142_环形链表_II {

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public ListNode detectCycle(ListNode head) {
        // 边界校验
        if (head == null || head.next == null) {
            return null;
        }

        Set<ListNode> set = new HashSet();

        while (head.next != null) {
            set.add(head);
            if (set.contains(head.next)) {
                return head.next;
            }
            head = head.next;
        }
        return null;
    }
}
