package LeetCodes.Test;

import java.util.Date;
import java.util.Random;

import MyLib.*;

public class SortingTest {
	// Check if the result is sorted
	   public static boolean isSorted(Comparable[] arr){
		   if(arr.length == 0) return true;
		   Comparable prev = arr[0];
		   for(int i = 1; i < arr.length; i++){
			   if(prev.compareTo(arr[i]) > 0)
				   return false;
			   prev = arr[i];
		   }
		   return true;
	   }
	   // print array to standard output
	   private static void show(final Comparable[] arr) {
		   System.out.println(java.util.Arrays.toString(arr));
	   }
	   public static void main(String[] args){
		   int len = 10000000;
		   int bnd = 10000;
		   Random rnd = new Random((new Date()).getTime());
		   Comparable[] arr = new Integer[len];
		   for(int i = 0; i < len; i++){
			   arr[i] = rnd.nextInt(bnd);
		   }
		   Comparable[] backup;
		   StopWatch clicker;
		   Sorting sort;

		   backup = arr.clone();
		   clicker = new StopWatch();
		   clicker.start();
		   sort = new QuickSort();
		   sort.sort(backup);
		   System.out.println("Time: " + clicker.stop() + " millisecond(s) by " + sort.name());
	       System.out.println(isSorted(backup)? "Sorted" : "Not Sorted");
		   
	       backup = arr.clone();
		   clicker = new StopWatch();
		   clicker.start();
		   sort = new HeapSort();
		   sort.sort(backup);
		   System.out.println("Time: " + clicker.stop() + " millisecond(s) by " + sort.name());
	       System.out.println(isSorted(backup)? "Sorted" : "Not Sorted");
//	       show(arr);
	   }

}
