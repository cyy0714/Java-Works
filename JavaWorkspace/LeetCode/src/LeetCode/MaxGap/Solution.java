package LeetCode.MaxGap;

public class Solution {
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
}