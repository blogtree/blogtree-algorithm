package normal;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.algorithm.structure.ListNode;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.cn/problems/reverse-linked-list/?favorite=2cktkvj"></a>
 */
@Slf4j
public class No206_反转链表 {

    @Test
    public void test1() {
        ListNode list = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        ListNode reverseList = reverseList(list);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
