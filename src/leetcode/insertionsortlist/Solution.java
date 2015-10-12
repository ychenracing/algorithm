/**
 * ychen.
 * Copyright (c) Oct 12, 2015.
 */
package leetcode.insertionsortlist;

/**
 * <pre>
 * Sort a linked list using insertion sort.
 * </pre>
 * @author racing
 * @version $Id: Solution.java, v 0.1 Oct 12, 2015 8:45:59 AM racing Exp $
 */
public class Solution {

    public static class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;

        ListNode head1 = head;
        head1.next = null;
        ListNode head2 = head1.next;

        while (head2 != null) {
            ListNode cur = head1;
            ListNode curPre = cur;
            while (cur != null) {
                if (head2.val < cur.val) {
                    if (cur == head1) {
                        ListNode temp = head2;
                        head2 = head2.next;
                        temp.next = head1;
                        head1 = temp;
                    } else {
                        ListNode temp = head2;
                        head2 = head2.next;
                        curPre.next = temp;
                        temp.next = cur;
                    }
                }
                if (cur == head1)
                    cur = cur.next;
                else {
                    cur = cur.next;
                    curPre = curPre.next;
                }
                if (cur == null) {
                    ListNode temp = head2;
                    head2 = head2.next;
                    curPre.next = temp;
                    temp.next = null;
                }
            }
        }
        return head1;
    }

}
