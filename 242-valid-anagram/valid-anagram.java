class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> tmap =new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char key = s.charAt(i);
            smap.put(key,smap.getOrDefault(key,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char key =t.charAt(i);
            tmap.put(key,tmap.getOrDefault(key,0)+1);
        }
        for(char key : smap.keySet()){
            int val1= smap.get(key);
            if(!tmap.containsKey(key)) return false;
            int val2= tmap.get(key);
            if(val1!=val2) return false;
        }
        return true;
    }
}