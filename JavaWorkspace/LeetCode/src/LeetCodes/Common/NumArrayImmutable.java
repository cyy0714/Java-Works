package LeetCodes.Common;


// Source: https://leetcode.com/problems/range-sum-query-mutable/
public class NumArrayImmutable {
	private int[] sums;
    public NumArrayImmutable(int[] nums) {
        sums = new int[nums.length+1];
        sums[0] = 0;
        for(int i = 0; i < nums.length; i++){
        	sums[i+1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
    	return sums[j+1] - sums[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);