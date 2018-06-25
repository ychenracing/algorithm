package leetcode;

public class E2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0, reminder = 0;
        ListNode result = null, head = null;
        while (l1 != null && l2 != null) {
            reminder = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;

            if (head == null) {
                result = new ListNode(reminder);
                head = result;
            } else {
                result.next = new ListNode(reminder);
                result = result.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode current = null;
        if (l1 != null)
            current = l1;
        else if (l2 != null)
            current = l2;

        while (current != null) {
            reminder = (current.val + carry) % 10;
            carry = (current.val + carry) / 10;
            result.next = new ListNode(reminder);
            result = result.next;
            current = current.next;
        }

        if (carry != 0) {
            ListNode lastNode = new ListNode(carry);
            result.next = lastNode;
        }

        return head;
    }

    public static class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);

        E2AddTwoNumbers solution = new E2AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(list1, list2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
