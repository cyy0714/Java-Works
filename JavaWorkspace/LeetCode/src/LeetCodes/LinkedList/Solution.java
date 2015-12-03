package LeetCodes.LinkedList;

import MyLib.ListNode;

public class Solution {
	public Solution(){}
	
	/**
	 * Sorted LinkedList
	 */
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode left = null, right = null, pivot = head;
        
        head = head.next;
        ListNode pLeft = null, pRight = null;
        while(head != null){
            if(head.val <= pivot.val) {
                if(left == null) {
                    left = head;
                    pLeft = left;
                }
                else {
                    pLeft.next = head;
                    pLeft = pLeft.next;
                }
            }
            if(head.val > pivot.val){
                if(right == null) {
                    right = head;
                    pRight = right;
                }
                else {
                    pRight.next = head;
                    pRight = pRight.next;
                }
            }
            head = head.next;
        }
        if(pLeft != null) pLeft.next = null;
        if(pRight != null) pRight.next = null;
        
        left = sortList(left);
        right = sortList(right);
        
        if(left != null){
            pLeft = left;
            while(left.next != null)
                left = left.next;
            left.next = pivot;
            pivot.next = right;
            return pLeft;
        }
        else{
            pivot.next = right;
            return pivot;
        }
    }
    
    /**
     * Merge Two Sorted LinkedList
     */
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
    
    /**
	 * Write a program to find the node at which the intersection of two singly linked lists begins.
	 * For example, the following two linked lists:
	 * A:          a1 → a2
	 *    					↘
	 *    					  c1 → c2 → c3
	 *    					 ↗            
	 * B:     b1 → b2 → b3
	 * begin to intersect at node c1.
	 * @param headA head of link list A
	 * @param headB head of link list B
	 * @return
	 */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        int diff = length(headA) - length(headB);
        while(diff > 0){
            headA = headA.next;
            diff --;
        }
        while(diff < 0){
            headB = headB.next;
            diff ++;
        }
        return goTogether(headA, headB);
    }
    public ListNode goTogether(ListNode headA, ListNode headB){
        if(headA == headB) return headA;
        return goTogether(headA.next, headB.next);
    }
    public int length(ListNode head){
        if(head == null) return 0;
        return length(head.next) + 1;
    }
}
