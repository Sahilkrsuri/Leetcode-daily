class Solution {
    public int largestAltitude(int[] gain) {
        int maxAlt =0;
        int n=gain.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=gain[i];
            maxAlt=Math.max(sum,maxAlt);
        }
        return maxAlt; 
    }
}