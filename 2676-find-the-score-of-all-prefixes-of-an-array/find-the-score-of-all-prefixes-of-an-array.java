class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        int max = nums[0];
        nums[0]+=nums[0];
        ans[0]=nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(nums[i], max);
            nums[i]=nums[i] + max;
            ans[i] = ans[i-1]+nums[i];
        }
        return ans;

    }
}