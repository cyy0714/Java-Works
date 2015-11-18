package LeetCode.MergeTwoSortedList;



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode next = null;
        while(l1 != null || l2 != null){
        	ListNode tmp = null;
            if(l1 == null){
                tmp = l2;
                l2 = l2.next;
            }
            else if(l2 == null){
                tmp = l1;
                l1 = l1.next;
            }
            else {
                tmp = (l1.val > l2.val)? l2 : l1;
                if (l1.val > l2.val)
                    l2 = l2.next;
                else
                    l1 = l1.next;
            }
            
            if(head == null){
                head = tmp;
                next = head;
            }
            else{
            	next.next = tmp;
                next = next.next;
            }
        }
        return head;
    }
}