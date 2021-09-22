import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/split-linked-list-in-parts/"></a>
 */
@Slf4j
public class No725_分隔链表 {

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.append(2).append(3);
        ListNode[] arr = splitListToParts(head, 5);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.append(2).append(3).append(4).append(5)
                .append(6).append(7).append(8).append(9).append(10);
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode append(int val) {
            ListNode node = new ListNode(val);
            this.next = node;
            return node;
        }
    }
}
