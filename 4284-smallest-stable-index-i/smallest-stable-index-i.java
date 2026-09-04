class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n= nums.length;
        if(n==1) return 0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(nums[i],max);
            int min = Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                min=Math.min(nums[j],min);
            }
            int instable=max-min;
            if(instable<=k) return i;     
        }
        return -1;
    }

}