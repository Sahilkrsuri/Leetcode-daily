class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        int[] freq = new int[51];

        int low = 0;
        int high = k - 1;

        while (high < n) {

            boolean[] present = new boolean[51];

            for (int i = low; i <= high; i++) {
                present[nums[i]] = true;
            }

            for (int i = 0; i <= 50; i++) {
                if (present[i]) {
                    freq[i]++;
                }
            }

            low++;
            high++;
        }

        int max = -1;

        for (int i = 0; i <= 50; i++) {
            if (freq[i] == 1) {
                max = i;
            }
        }

        return max;
    }
}