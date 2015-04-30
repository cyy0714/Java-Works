package SortedLinkedList;

public class Solution {
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
}
