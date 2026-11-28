class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double maxSum=0;
        int i =0;
        int j =0;
        double sum=0;

        while(j<k){
            sum+=nums[j++];
        }
        maxSum= sum;
       

        i++;
        while(j<n){
            sum = sum -nums[i-1]+nums[j];
            maxSum =Math.max(maxSum,sum);
            i++;
            j++;
        }
        return maxSum/k;
        

    }
}