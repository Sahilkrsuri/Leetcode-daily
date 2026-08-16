class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        int left=0;
        int maxLen=0;

        HashMap<Character,Integer> map = new HashMap<>();

        for(int right=0; right<n; right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch,0)+1);

            while(map.get(ch)>1){
                char leftCh = s.charAt(left);
                map.put(leftCh, map.get(leftCh)-1);

                if(map.get(leftCh)==0){
                    map.remove(leftCh);
                }
                left++;
            }
            int len= right-left+1;
            maxLen=Math.max(len,maxLen);

        }
        return maxLen;
    }
}