class Solution {
    public int search(int[] nums, int target) {
        return BSearch(nums,target,0,nums.length-1);
    }
    public int BSearch(int[] a, int t, int s, int e){
        if(s>e) return -1;
        int mid = s+(e-s)/2;
        if(a[mid]==t) return mid;
        else if(t>a[mid]) return BSearch(a,t,mid+1,e);
        else return BSearch(a,t,s,mid-1);
    }
}