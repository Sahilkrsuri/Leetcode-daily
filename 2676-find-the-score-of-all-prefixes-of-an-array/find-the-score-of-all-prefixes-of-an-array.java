class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n= nums.length;
        long sum=0;
        long max=nums[0];
        long[] ans = new long[n];
        for(int i=0;i<n;i++){
            if(max < nums[i]) max=nums[i];
            sum += nums[i] + max;
            ans[i]=sum;
        }
        return ans;
    }
}