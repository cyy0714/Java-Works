package MergeTwoSortedList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arra[] = new int[]{};
		int arrb[] = new int[]{1, 2, 4};
		
		ListNode a = null;
		ListNode b = null;
		
		if(arra.length > 0){
			ListNode next = null;
			for (int i : arra){
				if( a == null){
					a = new ListNode(i);
					next = a;
				}
				else{
					next.next = new ListNode(i);
					next = next.next;
				}
			}
		}
		if(arrb.length > 0){
			ListNode next = null;
			for (int i : arrb){
				if( b == null){
					b = new ListNode(i);
					next = b;
				}
				else{
					next.next = new ListNode(i);
					next = next.next;
				}
			}
		}
		
		Solution sol = new Solution();
		ListNode newList = sol.mergeTwoLists(a, b);
		
		while(newList != null){
			System.out.print(newList.val + ", ");
			newList = newList.next;
		}
		System.out.println();
	}

}
