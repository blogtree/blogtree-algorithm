package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.algorithm.structure.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/"></a>
 */
@Slf4j
public class No83_删除排序链表中的重复元素 {

    @Test
    public void test1() {
        ListNode list = ListNode.buildList(new int[]{1, 1, 2});
        ListNode newList = deleteDuplicates(list);
        Integer[] newArray = newList.toArray();
        assert Arrays.equals((new Integer[]{1, 2}), newArray);
    }

    @Test
    public void test2() {
        ListNode list = ListNode.buildList(new int[]{1, 1, 2, 3, 3});
        ListNode newList = deleteDuplicates(list);
        Integer[] newArray = newList.toArray();
        assert Arrays.equals((new Integer[]{1, 2, 3}), newArray);
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode tempNode = head;
        while (tempNode.next != null) {
            if (tempNode.val == tempNode.next.val) {
                tempNode.next = tempNode.next.next;
            }else {
                tempNode = tempNode.next;
            }
        }
        return firstNode;
    }
}
