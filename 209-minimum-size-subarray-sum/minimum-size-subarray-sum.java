class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            sum += nums[j];

            while (sum >= target) {
                int len = j - i + 1;
                minLen = Math.min(minLen, len);

                sum -= nums[i];
                i++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}