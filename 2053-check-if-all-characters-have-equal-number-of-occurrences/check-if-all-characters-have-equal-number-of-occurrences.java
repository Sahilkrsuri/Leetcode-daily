class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        int prev=-1;
       for(int i = 0; i<26;i++){
        if(freq[i]!=0){
            if(prev!=-1 && prev != freq[i]){
                return false;
            }
            prev= freq[i];
        }
        
       }
       return true;
    }
}