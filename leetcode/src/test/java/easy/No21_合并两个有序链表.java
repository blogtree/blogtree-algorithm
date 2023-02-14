package easy;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.algorithm.structure.ListNode;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/"></a>
 */
@Slf4j
public class No21_合并两个有序链表 {

    @Test
    public void test1() {
        ListNode l1 = new ListNode(1)
                .setNext(2).setNext(4);
        ListNode l2 = new ListNode(1)
                .setNext(3).setNext(4);
        ListNode l3 = mergeTwoLists(l1, l2);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode result = l3;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    l3.next = l1;
                    l1 = l1.next;
                } else {
                    l3.next = l2;
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }

            l3 = l3.next;
        }
        return result.next;
    }
}
