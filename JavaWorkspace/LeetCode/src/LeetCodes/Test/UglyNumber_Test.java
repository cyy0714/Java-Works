package LeetCodes.Test;

import LeetCodes.Common.Solution;


public class UglyNumber_Test {
	public static void main(String[] args){
		Solution sol = new Solution();
		int[] primes = new int[]{2, 3, 5};
		long ans = sol.nthSuperUglyNumber(200, primes);
		System.out.println(ans);
	}
}
