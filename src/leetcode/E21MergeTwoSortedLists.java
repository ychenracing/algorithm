/**
 * ychen. Copyright (c) 2018年4月17日.
 */
package leetcode;

/**
 * 
 * @author racing
 * @version $Id: TwentyOne21MergeTwoSortedLists.java, v 0.1 2018年4月17日 下午7:04:14 racing Exp $
 */
public class E21MergeTwoSortedLists {

    public static class ListNode {
        int      val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode h1 = l1;
        if (l1.val > l2.val) {
            l1 = l2;
            l2 = h1;
            h1 = l1;
        }
        ListNode p1 = l1;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (p1 != l1) {
                    p1 = l1;
                }
                l1 = l1.next;
                continue;
            }
            p1.next = l2;
            l2 = l1;
            l1 = p1.next;
        }
        if (l1 == null) {
            p1.next = l2;
        }
        return h1;
    }

}
