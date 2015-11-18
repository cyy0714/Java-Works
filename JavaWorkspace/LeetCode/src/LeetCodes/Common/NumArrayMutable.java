package LeetCodes.Common;


// Source: https://leetcode.com/problems/range-sum-query-mutable/
public class NumArrayMutable {
	private int[] nums, segmentTree;
	private int size, height;
    public NumArrayMutable(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
       	this.height = (this.size > 0) ? (int) Math.ceil(Math.log10(this.size)/Math.log10(2)) : 0;
       	int maxSize = ((int)Math.pow(2, (this.height+1))) - 1;
        this.segmentTree = new int[maxSize];
        if(this.size > 0)
        	initST(0, size-1, 0);
    }

    /**
     *  Initialize Segment Tree
     * @param ss Segment Start
     * @param se Segment End
     * @param si Segment Index
     */
    private int initST(int ss, int se, int si) {
		if (ss == se)
			this.segmentTree[si] = this.nums[ss];
		else{
			int mid = (ss + se)/2;
			this.segmentTree[si] = initST(ss, mid, si * 2 + 1) + 
					initST(mid+1, se, si * 2 + 2);
		}
		return this.segmentTree[si];
	}
    
    /**
     * Update Segment Tree
     * @param ss Segment Start
     * @param se Segment End
     * @param i Index
     * @param diff Difference of the update
     * @param si Segment Index
     */
    private void updateST(int ss, int se, int i, int diff, int si){
    	if (i < ss || i > se) return;
    	this.segmentTree[si] += diff;
    	if(ss != se){
    		int mid = (ss + se) / 2;
    		updateST(ss, mid, i, diff, si * 2 + 1);
    		updateST(mid+1, se, i, diff, si * 2 + 2);
    	}
    }
    
    /**
     * SumRange on Segment Tree
     * @param ss Segment Start
     * @param se Segment End
     * @param qs Query Start
     * @param qe Query End
     * @param si Segment Index
     * @return SumRange
     */
    private int sumRangeST(int ss, int se, int qs, int qe, int si){
    	if(qs <= ss && qe >= se) return this.segmentTree[si];
    	if(se < qs || ss > qe) return 0;
    	
    	int mid = (ss + se) / 2;
    	return sumRangeST(ss, mid, qs, qe, si * 2 + 1) +
    			sumRangeST(mid+1, se, qs, qe, si *2 + 2);
    }

	public void update(int i, int val) {
    	if(i < 0 || i >= this.size) return;
    	int diff = val - this.nums[i];
    	this.nums[i] = val;
    	updateST(0, this.size-1, i, diff, 0);
    }

    public int sumRange(int i, int j) {
    	if(i < 0 || j < 0 || i >= this.size || j >= this.size)  return 0;
    	return sumRangeST(0, this.size-1, i, j, 0);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);