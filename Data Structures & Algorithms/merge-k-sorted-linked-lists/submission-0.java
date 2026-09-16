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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 ) return null;

        int k = lists.length;
        //9 - 5 - 3 - 2 - 1
        

        //1,1,2,3,4,5
        //3,5
        while(k > 1){
            int write = 0;
            for(int i=0;i<k;i += 2){
                //for odd case
                if(i+1 < k){
                    lists[write++] = mergeTwoList(lists[i], lists[i+1]);
                }else{
                    lists[write++] = lists[i];
                }
            }
            k = write;

        }
        return lists[0];

    }
  
    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while(cur1 != null && cur2 !=null){
            if(cur1.val <= cur2.val){
                cur.next = cur1;
                cur = cur.next;

                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur = cur.next;

                cur2 = cur2.next;
            }
        }
        while(cur1 != null){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }
             while(cur2 != null){
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        return dummy.next;
    }
}
