package LeetCodes.Test;

import LeetCode.Tree.Solution;

public class IsValidSerializationTest {

	public static void main(String[] args) {
		String seq = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		Solution sol = new Solution();
		System.out.println(sol.isValidSerialization(seq));
	}

}
