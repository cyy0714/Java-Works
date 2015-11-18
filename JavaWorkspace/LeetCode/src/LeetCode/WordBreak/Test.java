package LeetCode.WordBreak;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		String[] arr = new String[]{"a"};
		for(String s : arr)
			dict.add(s);
		Solution sol = new Solution();
		System.out.println(sol.wordBreak("a", dict));
	}

}
