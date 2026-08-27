class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n= nums.length;
        //prefix sum
        for(int i=1;i<n;i++){
            nums[i]+=nums[i-1];
        }
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int s=0;
            int e=n-1;
            while(s<=e){
                int mid=s+(e-s)/2;
                if(nums[mid]>queries[i]) e=mid-1;
                else{
                    ans[i]=Math.max(mid+1,ans[i]);
                    s=mid+1;
                }
            }  
        }
        return ans;
        
    }
}