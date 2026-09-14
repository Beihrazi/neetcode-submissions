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
        if (head == null || head.next == null) return;
        
        ListNode dummy = new ListNode(0);

        ListNode slow = head;
        ListNode prevslow = slow;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            prevslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevslow.next = null;
        ListNode secondhalf = slow;
        ListNode prev = null;

        while(secondhalf !=null){
            ListNode temp = secondhalf.next;
            secondhalf.next = prev;
            prev = secondhalf;
            secondhalf = temp;
        }
        ListNode current = dummy;
        slow = head;

        while(slow != null){
            current.next = slow;
            current = slow;
            slow  = slow.next;
            
            current.next = prev;
            current = prev;
            prev = prev.next;
        }
        current.next = prev;
        
       
        //1,2 | 3,4,5

    }
}
