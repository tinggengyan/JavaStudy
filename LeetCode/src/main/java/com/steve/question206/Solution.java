package com.steve.question206;

/**
 * Reverse a singly linked list.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * Created by steveyan on 16-8-7.
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode pre = head;
        ListNode p = head.next;
        pre.next = null;
        ListNode nxt;
        while(p!=null) {
            nxt = p.next;
            p.next = pre;
            pre = p;
            p = nxt;
        }
        return pre;
    }
}
