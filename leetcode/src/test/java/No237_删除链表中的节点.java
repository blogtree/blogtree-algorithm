import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/delete-node-in-a-linked-list/"></a>
 */
@Slf4j
public class No237_删除链表中的节点 {

    @Test
    public void test1() {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(9);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        deleteNode(listNode2);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode append(int val) {
            this.next = new ListNode(val);
            return this.next;
        }
    }
}
