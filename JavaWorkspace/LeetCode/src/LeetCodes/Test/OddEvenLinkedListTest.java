package LeetCodes.Test;

import LeetCodes.LinkedList.Solution;
import MyLib.ListNode;

public class OddEvenLinkedListTest {
	private static ListNode createList(int[] arr){
		ListNode head = new ListNode(arr[0]);
		ListNode pointer = head;
		for(int i = 1; i < arr.length; i++){
			pointer.next = new ListNode(arr[i]);
			pointer = pointer.next;
		}
		return head;
	}

	public static void main(String[] args) {
		int arr[] = new int[]{1,2,3,4,5,6,7,8};
		ListNode head = createList(arr);
		
		Solution sol = new Solution();
		head = sol.oddEvenList(head);
		
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

}
