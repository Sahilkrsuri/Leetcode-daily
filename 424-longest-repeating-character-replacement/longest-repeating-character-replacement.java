class Solution {
    public int characterReplacement(String s, int k) {
        int n= s.length();
        int left=0;
        int maxLen=0;
        int maxFreq=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int temp=k;
        for(int right=0; right<n; right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            while((right-left+1)- maxFreq > k){
                char leftCh= s.charAt(left);
                map.put(leftCh,map.get(leftCh)-1);
                if(map.get(leftCh)==0){
                    map.remove(leftCh);
                }
                left++;
            }
            maxLen= Math.max(maxLen, right-left+1);
        }
        return maxLen;
        
    }
}