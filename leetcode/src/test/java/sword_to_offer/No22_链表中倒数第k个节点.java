package sword_to_offer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/"></a>
 */
@Slf4j
public class No22_链表中倒数第k个节点 {

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.append(2).append(3).append(4).append(5);
        ListNode res = getKthFromEnd(head, 2);
        assert 4 == res.val;
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode before = head;
        ListNode after = head;
        for (int i = 1; i < k; i++) {
            before = before.next;
        }

        while (before.next != null) {
            before = before.next;
            after = after.next;
        }

        return after;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode append(int val) {
            ListNode next = new ListNode(val);
            this.next = next;
            return this.next;
        }
    }
}
