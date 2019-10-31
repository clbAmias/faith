package com.learn.offer;

import java.util.ArrayList;

public class ListNodeOutput {
    /**
     * 题目描述
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     * <p>
     * 解题思路
     * 一种方法是利用栈来实现；
     * 另外一种方法是利用三个指针把链表反转，关键是 r 指针保存断开的节点。
     */
    public ArrayList<String> printListFromTailToHead(Node Node) {
        if (Node == null)
            return new ArrayList<String>();
        Node head = Node;
        Node cur = Node.next;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        }
        //此时Node的next还指向第二个node，所以要让Node.next=null,防止循环
        Node.next = null;
        ArrayList<String> res = new ArrayList<String>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }

}

