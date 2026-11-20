class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp= new int[n+1];
        return stairs(n);
    }
    public int stairs(int n){
        if(n<=2) return n;
        if(dp[n]!=0) return dp[n];
        dp[n]=stairs(n-1) + stairs(n-2);
        return dp[n];
    }
}