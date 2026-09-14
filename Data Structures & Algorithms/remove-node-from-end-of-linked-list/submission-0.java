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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        //1,2,3,4,5,6 n=2
        int count =0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while(cur != null){
            cur = cur.next;
            count++;
        }
        int length = count - n;
        if(length == 0){
            dummy.next = head.next;
        }
        int i=1;

        cur = dummy;

        while(i<length){
            cur = cur.next;
            i++;
        }
        
        cur.next = cur.next.next;
       return dummy.next;
        
    }
}
