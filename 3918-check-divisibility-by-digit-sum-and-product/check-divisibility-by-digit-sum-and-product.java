class Solution {
    public boolean checkDivisibility(int n) {
        int sum= 0;
        int product=1;
        int num=n;
        while(num != 0){
            int temp = num%10;
            sum+=temp;
            product*=temp;
            num/=10;
        }
        int totalSum=product+sum;
        if(n%totalSum==0) return true;
        return false;  
    }
}