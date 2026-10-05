class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int maxLen=0;
        while(j<n){
            char ch = s.charAt(j);
            map.put(ch ,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>1){
                char lch = s.charAt(i);
                map.put(lch,map.get(lch)-1);
                if(map.get(lch)==0){
                    map.remove(lch);
                }
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);

            j++;
        }
        return maxLen;
        
    }
}