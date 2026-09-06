class Solution {
    public boolean isPalindrome(String s) {
        int n= s.length();
        String str="";
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch>=97 && ch<=122){
                str +=ch;
            }
            else if(ch>=65 && ch<=90){
                str+=(char)(ch+32);
            }
            else if(ch>=48 && ch<=57){
                str+=ch;
            }
        }

        return checkPalindrome(str);
    }
    public boolean checkPalindrome(String s){
        int n= s.length();
        if(n<1) return true;
        int i=0;
        int j=n-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}