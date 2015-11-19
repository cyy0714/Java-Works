package LeetCodes.Common;

public class Solution {
	public Solution(){}
	
	/**
	 * 	Given an unsorted array of integers, 
	 * find the length of longest increasing subsequence.
	 * Follow source: http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
		For example,
		Given [10, 9, 2, 5, 3, 7, 101, 18],
		The longest increasing subsequence is [2, 3, 7, 101], 
		therefore the length is 4. Note that there may be 
		more than one LIS combination, it is only necessary 
		for you to return the length.
	 * @param nums The array of numbers
	 * @return the longest increasing subsequence
	 */	
	public int lengthOfLIS(int[] nums) {
        return LongestIncreasingSubsequenceLength(nums, nums.length);
    }
    // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    private int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }
 
        return r;
    }
 
    private int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one
        if(size == 1) return 1;
        if(size == 0) return 0;
 
        int[] tailTable   = new int[size];
        int len; // always points empty slot
 
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];
 
            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
 
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
        }
 
        return len;
    }
	
	/**
	 * Max Gap
	 */
    private class MaxGapNode{
        private int size = 0;
        private int min, max;
        public MaxGapNode(){
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
        public void add(int n){ 
            size++;
            if(n < min) min = n;
            if(n > max) max = n;
        }
        public int size() { return size; }
        public int getMin(){  return min; }
        public int getMax(){  return max; }
        
    }
    public int maximumGap(int[] num) {
        if(num.length < 2) return 0;
        int n = num.length;
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i : num){
            if(i < min) min = i;
            if(i > max) max = i;
        }
        int delta = (max - min)/(n-1) + 1;
        MaxGapNode[] buckets = new MaxGapNode[n-1];
        for(int i = 0; i < n-1; i ++)
            buckets[i] = new MaxGapNode();
        for(int i : num){
            if(i == min || i == max) continue;
            int k = (i - min)/delta;
            buckets[k].add(i);
        }
        int diff = 0;
        int prev = min;
        for(int i = 0; i < n-1; i++){
            if(buckets[i].size() == 0) continue;
            int d = buckets[i].getMin() - prev; 
            if(diff < d) diff = d;
            prev = buckets[i].getMax();
        }
        if(diff < (max - prev)) diff = max - prev;
        return diff;
    }
    
    /**
     * Compare Version Number
     */
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        
        for(int i = 0; i < str1.length && i < str2.length; i++){
            if(Integer.parseInt(str1[i]) == Integer.parseInt(str2[i])) continue;
            if(Integer.parseInt(str1[i]) > Integer.parseInt(str2[i]))
                return 1;
            else
                return -1;
        }
        if(str1.length == str2.length) return 0;
        if(str1.length > str2.length) return 1;
        else return -1;
    }
}
