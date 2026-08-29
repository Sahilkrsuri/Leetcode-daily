class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int m= bookings.length;
        int[] ans = new int[n];
        for(int i=0;i<m;i++){
            int s= bookings[i][0];
            int e= bookings[i][1];
            int num= bookings[i][2];
            for(int j=s-1;j<e;j++){
                ans[j]+=num;
            }
        }
        return ans;
    }
}