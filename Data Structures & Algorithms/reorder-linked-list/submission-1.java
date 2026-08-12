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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = slow.next;
        slow.next = null;
        
        ListNode prev = null;
        ListNode curr = l2;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        l2 = prev;

        ListNode first = head;
        while(l2 != null){
            ListNode temp1 = first.next;
            ListNode temp2 = l2.next;

            first.next = l2;
            l2.next = temp1;

            first = temp1;
            l2 = temp2;
        }

        
    }
}
