package MyLib;

import java.util.Comparator;
import java.util.Date;
import java.util.Random;

public class HeapSort implements Sorting{
	public HeapSort(){}
	
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param pq the array to be sorted
     */
	@Override
	public void sort(Comparable[] arr){
		if(arr.length <= 1) return;
		int n = arr.length;

        for (int i = (n - 1) / 2; i >= 0; i--)
            heapify(arr, i, n);

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
	}
   /***************************************************************************
    * Helper functions to restore the heap invariant.
    ***************************************************************************/

	private void heapify(Comparable[] arr, int i, int n) {
        int lft = i * 2;
        int rgt = lft + 1;
        int grt = i;

        if (lft < n && !less(arr, lft, grt)) grt = lft;
        if (rgt < n && !less(arr, rgt, grt)) grt = rgt;
        if (grt != i) {
            swap(arr, i, grt);
            heapify(arr, grt, n);
        }
	}


/***************************************************************************
    * Helper functions for comparisons and swaps.
    * Indices are "off-by-one" to support 1-based indexing.
    ***************************************************************************/
	
	private void swap(Comparable[] arr, int i, int j) {
		Comparable tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}
   private boolean less(Comparable[] arr, int i, int j) {
		return arr[i].compareTo(arr[j]) < 0;
   }
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "HeapSort";
	}
   
}
