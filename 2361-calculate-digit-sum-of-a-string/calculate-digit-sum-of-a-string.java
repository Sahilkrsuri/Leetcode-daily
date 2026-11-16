class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            String t = "";
            int i = 0;
            while (i < s.length()) {
                String num;
                if (i + k <= s.length()) {
                    num = s.substring(i, i + k);
                    i += k;
                } else {
                    num = s.substring(i);
                    i = s.length();
                }
                int sum = 0;
                for (int j = 0; j < num.length(); j++) {
                    sum += num.charAt(j) - '0';
                }
                t += sum;
            }
            s = t;
        }

        return s;
    }
}