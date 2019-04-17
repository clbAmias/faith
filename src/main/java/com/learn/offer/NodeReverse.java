package com.learn.offer;

import java.util.LinkedList;

public class NodeReverse {

    public static void main(String[] args) {
        LinkedList<Node> linkedList =  new LinkedList<Node>();
        Node node = new Node("000");
        Node node1 = new Node("345");
        Node node2 = new Node("789");
        Node node3 = new Node("123");
        Node node4 = new Node("888");
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        reverse(node);

    }

    public static Node reverse(Node head){
        if(head==null){
            return head;
        }
        if(  head.next == null){
            System.out.println(head.val);
            return head;
        }
        Node preHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        System.out.println(head.val);
        return preHead;

    }


}
