class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int product = 1;
        int nzp = 1;
        int zeros = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                zeros++;
            } else {
                nzp *= nums[i];
            }

            product *= nums[i];
        }

        // More than one zero
        if (zeros > 1) {
            for (int i = 0; i < n; i++) {
                nums[i] = 0;
            }
        }

        // Exactly one zero
        else if (zeros == 1) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    nums[i] = nzp;
                } else {
                    nums[i] = 0;
                }
            }
        }

        // No zero
        else {
            for (int i = 0; i < n; i++) {
                nums[i] = product / nums[i];
            }
        }

        return nums;
    }
}