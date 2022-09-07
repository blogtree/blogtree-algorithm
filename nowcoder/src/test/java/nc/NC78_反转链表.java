package nc;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.algorithm.structure.ListNode;
import org.junit.Test;

/**
 * @see <a href="https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=117&tqId=37777&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Ftab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title="></a>
 */
@Slf4j
public class NC78_反转链表 {

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：链表
     * 分析：
     * 1 从链表头遍历
     * 2 声明临时变量，存储上一个节点、当前节点、下一个节点
     * 3 遍历下一个元素。
     * 4
     * 5 将当前节点的 next 指向 上一个节点
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = null;
        while (head.next != null){
            head.next = last;
            // 将当前节点存储为 上一个节点
            last = head;
            // 指针向下遍历
            head = head.next;
            // 设置当前节点的next为上一个指针
            head.next = last;
        }
        return null;
    }
}
