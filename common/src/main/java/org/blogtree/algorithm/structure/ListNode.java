package org.blogtree.algorithm.structure;

import lombok.ToString;

/**
 * 链表节点
 */
@ToString
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode setNext(int val) {
        next = new ListNode(val);
        return next;
    }

    /**
     * 根据int数组，构造单向链表
     *
     * @param vals int数组
     * @return 单向联表
     */
    public static ListNode buildList(int[] vals) {
        if (vals.length == 0) {
            return null;
        }
        ListNode temp = new ListNode(vals[0]);
        ListNode head = temp;
        for (int i = 1; i < vals.length; i++) {
            temp = temp.setNext(vals[i]);
        }
        return head;
    }
}