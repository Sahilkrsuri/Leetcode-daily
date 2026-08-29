class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int m= bookings.length;
        int[] ans = new int[n];
        for(int i=0;i<m;i++){
            int s= bookings[i][0];
            int e= bookings[i][1];
            int num= bookings[i][2];
            ans[s-1] += num;
            if(e<n) ans[e] -= num; 
        }
        for(int i=1;i<n;i++){
            ans[i]+=ans[i-1];
        }
        return ans;
    }
}