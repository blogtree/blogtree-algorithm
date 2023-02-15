package org.blogtree.algorithm.structure;

import lombok.ToString;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

    public String print() {
        StringBuilder builder = new StringBuilder();
        ListNode tempNode = this;
        while (tempNode != null) {
            builder.append(tempNode.val).append(" -> ");
            tempNode = tempNode.next;
        }
        return builder.toString();
    }

    public Integer[] toArray() {
        List<Integer> list = new LinkedList<>();
        ListNode tempNode = this;
        while (tempNode != null) {
            list.add(tempNode.val);
            tempNode = tempNode.next;
        }
        return list.toArray(new Integer[0]);
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