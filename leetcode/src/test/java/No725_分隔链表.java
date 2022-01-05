import lombok.extern.slf4j.Slf4j;
import org.blogtree.algorithm.structure.ListNode;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/split-linked-list-in-parts/"></a>
 */
@Slf4j
public class No725_分隔链表 {

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.setNext(2).setNext(3);
        ListNode[] arr = splitListToParts(head, 5);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.setNext(2).setNext(3).setNext(4).setNext(5)
                .setNext(6).setNext(7).setNext(8).setNext(9).setNext(10);
        ListNode[] arr = splitListToParts(head, 3);
    }

    @Test
    public void test3() {
    }


    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];
        if (head == null) {
            return arr;
        }

        int total = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            total++;
        }

        int minCount = total / k;
        int remainder = total % k;

        int i = 0;
        if (minCount == 0) {
            temp = head;
            while (temp != null) {
                arr[i] = new ListNode(temp.val);
                temp = temp.next;
                i++;
            }
            return arr;
        }


        ListNode tempBefore = null;
        temp = head;
        arr[0] = head;
        int arrIndex = 1;
        i = 0;
        while (temp != null) {
            if (i == (remainder > 0 ? (minCount + 1) : minCount)) {
                arr[arrIndex++] = temp;
                if (tempBefore != null) {
                    tempBefore.next = null;
                }
                remainder--;
                i = 0;
            }
            tempBefore = temp;
            temp = temp.next;
            i++;
        }
        return arr;
    }
}
