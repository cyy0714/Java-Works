package MyLib;

import java.util.Date;
import java.util.Random;

public class QuickSort implements Sorting{
	Random rnd;
	public QuickSort(){
		rnd = new Random((new Date()).getTime());
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "QuickSort";
	}

	@Override
	public void sort(Comparable[] arr) {
		int head = 0, tail = arr.length - 1;
		sort(arr, head, tail);
	}
	public void sort(Comparable[] arr, int head, int tail){
		if(head < 0 || tail >= arr.length) return;
		if(head < tail){
			int pivot = partition(arr, head, tail);
			sort(arr, head, pivot-1);
			sort(arr, pivot+1, tail);
		}
	}
	private int partition(Comparable[] arr, int head, int tail){
		int ind = rnd.nextInt(tail - head) + head;
		Comparable pivot = arr[ind];
		swap(arr, ind, tail);
		int i = head;
		for(int j = head; j < tail; j++){
			if(pivot.compareTo(arr[j]) >= 0)
				swap(arr, i++, j);
		}
		swap(arr, i, tail);
		return i;
	}
	

	private void swap(Comparable[] arr, int i, int j) {
		Comparable tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}
}
