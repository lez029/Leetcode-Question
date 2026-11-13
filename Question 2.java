/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        

        if (l1 == null && l2 == null) {
            return null;
        };
        if (l1 == null) {
            if (l2.val >= 10) {
                l3.val = l2.val % 10;
                if (l2.next != null) {
                    l2.next.val += l2.val / 10;
                } else {
                    l2.next = new ListNode(l2.val / 10);
                }
            } else {
                l3.val = l2.val;
            }
            l3.next = addTwoNumbers(null, l2.next);
            return l3;
        } else if (l2 == null) {
            if (l1.val >= 10) {
                l3.val = l1.val % 10;
                if (l1.next != null) {
                    l1.next.val += l1.val / 10;
                } else {
                    l1.next = new ListNode(l1.val / 10);
                }
            } else {
                l3.val = l1.val;
            }
            l3.next = addTwoNumbers(l1.next, null);
            return l3;
        }
        int digit_sum = l1.val + l2.val;
        if (digit_sum >= 10) {
            l3.val = digit_sum % 10;
            if (l1.next != null) {
                l1.next.val += digit_sum / 10;
            } else {
                l1.next = new ListNode(digit_sum / 10);
            }
            l3.next = addTwoNumbers(l1.next, l2.next);
        } else {
            l3.val = digit_sum;
            l3.next = addTwoNumbers(l1.next, l2.next);
        }
        return l3;
    }
}
