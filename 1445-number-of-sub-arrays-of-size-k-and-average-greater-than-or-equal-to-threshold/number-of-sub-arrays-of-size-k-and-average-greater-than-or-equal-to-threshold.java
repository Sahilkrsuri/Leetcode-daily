class Solution {
    public int numOfSubarrays(int[] nums, int k, int t) {
        
        int n = nums.length;
        int i =0;
        int j =0;
        int sum=0;
        int count=0;

        while(j<k){
            sum+=nums[j++];
        }
        if(sum/k>=t) count++;
        
        i++;
        while(j<n){
            sum = sum -nums[i-1]+nums[j];
            if(sum/k>=t) count++;
            i++;
            j++;
        }
        return count;
        
    }
}