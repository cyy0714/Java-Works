package LeetCodes.Test;

import LeetCodes.Common.NumArrayMutable;

public class NumArray_Test {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 3, 5};
		NumArrayMutable num = new NumArrayMutable(arr);
		
		System.out.println(num.sumRange(0, 2));
		num.update(1, 2);
		System.out.println(num.sumRange(0, 2));

	}

}
