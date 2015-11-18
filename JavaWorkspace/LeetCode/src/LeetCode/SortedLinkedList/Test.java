package LeetCode.SortedLinkedList;

import java.util.Random;

import MyLib.StopWatch;

public class Test {

	public static void main(String[] args) {
		ListNode head = null;
		int K = 20000;
		int[] arr = new int[K];
		Random rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());
		for(int i = 0; i < K; i++)
			arr[i] = rnd.nextInt(10);
		ListNode pointer = null;
		for(int i : arr){
			ListNode n = new ListNode(i);
			if(head == null){
				head = n;
				pointer = head;
			}
			else{
				head.next = n;
				head = n;
			}
		}
		
		StopWatch timer = new StopWatch();
		timer.start();
		Solution sol = new Solution();
		head = sol.sortList(pointer);
		String duration = timer.stop();
		
		while(head != null){
			System.out.print(head.val + ", ");
			head = head.next;
		}
		System.out.println();
		System.out.println("\n\t Time Consumption: " + duration + " milliseconds.");
	}

}
