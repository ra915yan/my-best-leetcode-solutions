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
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carry = 0;
        int value = 0;
        int digitValue = 0;
        while(l1 != null || l2 != null || carry > 0){
            value = 0;
            if(l1 != null) value += l1.val;
            if(l2 != null) value += l2.val;
            value += carry;
            carry = value / 10;
            digitValue = value % 10;
            current.next = new ListNode(digitValue);
            current = current.next;

            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        

        return dummy.next;
    }
}