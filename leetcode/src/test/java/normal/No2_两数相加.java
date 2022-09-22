package normal;

import org.blogtree.algorithm.structure.ListNode;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/add-two-numbers/"></a>
 */
public class No2_两数相加 extends BaseTest {

    @Test
    public void test1() {
        Solution solution = new Solution();
        ListNode l1 = ListNode.buildList(new int[]{2, 4, 3});
        ListNode l2 = ListNode.buildList(new int[]{5, 6, 4});
        Object res = solution.addTwoNumbers(l1, l2);
        log.info("res={}", res);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        ListNode l1 = ListNode.buildList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNode.buildList(new int[]{9, 9, 9, 9});
        solution.addTwoNumbers(l1, l2);
    }


    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode l3 = new ListNode();
            add(l1, l2, 0, l3);
            return l3.next;
        }

        public void add(ListNode l1, ListNode l2, int lastSum, ListNode l3) {
            int over = lastSum > 9 ? 1 : 0;
            if (l1 == null && l2 == null && over == 0) {
                return;
            }
            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + over;
                appendToL3(sum, l3);
                add(l1.next, l2.next, sum, l3.next);
            } else if (l1 != null) {
                int sum = l1.val + over;
                appendToL3(sum, l3);
                add(l1.next, null, sum, l3.next);
            } else if (l2 != null) {
                int sum = l2.val + over;
                appendToL3(sum, l3);
                add(null, l2.next, sum, l3.next);
            } else {
                if (over != 0) {
                    appendToL3(1, l3);
                }
            }
        }

        public void appendToL3(int sum, ListNode l3) {
            l3.next = new ListNode(sum > 9 ? sum - 10 : sum);
        }
    }
}
