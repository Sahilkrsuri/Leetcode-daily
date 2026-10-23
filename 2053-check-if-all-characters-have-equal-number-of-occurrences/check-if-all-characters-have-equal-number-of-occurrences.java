class Solution {
    public boolean areOccurrencesEqual(String s) {
        // int[] freq = new int[26];
        // for(int i = 0;i<s.length();i++){
        //     char ch = s.charAt(i);
        //     freq[ch-'a']++;
        // }
        int prev=-1;
        while(s.length()>0){
            char ch = s.charAt(0);
            String s2 = s.replace(ch+"","");
            int count =s.length()-s2.length(); 
            if(prev!=-1 && prev != count){
                return false;
            }
            prev=count;
            s=s2;
        }
        return true;
    }
}