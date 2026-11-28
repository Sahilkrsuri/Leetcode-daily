class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double maxAvg=Integer.MIN_VALUE;
        int i =0;
        int j =0;
        double sum=0;

        while(j<k){
            sum+=nums[j++];
        }
        double avg =sum/k;
        maxAvg =Math.max(maxAvg,avg); 
       

        i++;
        while(j<n){
            sum = sum -nums[i-1]+nums[j];
            avg =sum/k;
            maxAvg =Math.max(maxAvg,avg);
            i++;
            j++;
        }
        return maxAvg;
        

    }
}