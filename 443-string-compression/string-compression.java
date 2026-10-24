class Solution {
    public int compress(char[] chars) {

        StringBuilder s = new StringBuilder();
        int n = chars.length;
        int i = 0;
        int j = 0;

        while (i < n) {
            char ch = chars[i];
            int count = 0;
            while (i < n && chars[i] == ch) {
                count++;
                i++;
            }

            chars[j++]=ch;

            if (count > 1) {
                //chars[j++]=(char)(count+'0');
                for(char c : String.valueOf(count).toCharArray()){
                    chars[j++]= c;
                }
            }
        }
        return j;
    }
}