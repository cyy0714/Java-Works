package LeetCodes.Test;

import LeetCodes.Common.Solution;


public class UglyNumber_Test {
	public static void main(String[] args){
		Solution sol = new Solution();
		int[] primes = new int[]{7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};
		long ans = sol.nthSuperUglyNumber(50000-11459, primes);
		System.out.println(ans);
	}
}
