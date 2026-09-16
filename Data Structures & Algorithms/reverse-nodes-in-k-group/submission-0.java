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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        ListNode groupPrev = dummy; 

        ListNode oldHead = head;
        ListNode cur = oldHead;
        ListNode prev = null; 

        while(cur != null){
            int i=0;
            int available = countNode(cur, k);

            if(available < k){
                break;
            }
            
                while(i < k){
                    ListNode next = cur.next; //5,6,null
                    cur.next = prev; //null,4,5
                    prev = cur; //3 | 4,5,6 = 6 - 5 - 4 - null
                    cur = next; //4 | 5,6, null
                    i++;
                }
                i = 0;
                oldHead.next = cur; //4, null
                groupPrev.next = prev; //new head
                
                groupPrev = oldHead;
                oldHead = cur;
                prev = null;
                        
        }  
        return dummy.next;    
    }
    public int countNode(ListNode h1, int k){
        int i = 0;
        ListNode cur = h1;
        while(i<k && cur != null){
            cur = cur.next;
            i++;
        }
        return i;
    }
    
}
