class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0 ; i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int prev=-1;
        for(int e : map.values()){
            if(prev!=-1 && e != prev){
                return false;
            }
            prev=e;
        }
        return true;
    }
}