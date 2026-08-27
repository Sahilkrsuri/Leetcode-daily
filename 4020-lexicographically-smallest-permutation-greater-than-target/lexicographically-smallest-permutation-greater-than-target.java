class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {

            int x = target.charAt(i) - 'a';

            // Try to keep the same character
            if (freq[x] > 0) {
                freq[x]--;
                ans.append(target.charAt(i));
                continue;
            }

            // Try a character greater than target[i]
            int greater = findGreater(freq, x);

            if (greater != -1) {
                ans.append((char) ('a' + greater));
                freq[greater]--;

                appendRemaining(ans, freq);

                return ans.toString();
            }

            // Backtrack
            while (ans.length() > 0) {

                int last = ans.length() - 1;
                int ch = ans.charAt(last) - 'a';

                ans.deleteCharAt(last);
                freq[ch]++;

                greater = findGreater(freq, ch);

                if (greater != -1) {
                    ans.append((char) ('a' + greater));
                    freq[greater]--;

                    appendRemaining(ans, freq);

                    return ans.toString();
                }
            }

            return "";
        }

        // target itself was formed, so find next greater permutation
        while (ans.length() > 0) {

            int last = ans.length() - 1;
            int ch = ans.charAt(last) - 'a';

            ans.deleteCharAt(last);
            freq[ch]++;

            int greater = findGreater(freq, ch);

            if (greater != -1) {
                ans.append((char) ('a' + greater));
                freq[greater]--;

                appendRemaining(ans, freq);

                return ans.toString();
            }
        }

        return "";
    }

    private int findGreater(int[] freq, int x) {

        for (int i = x + 1; i < 26; i++) {
            if (freq[i] > 0) {
                return i;
            }
        }

        return -1;
    }

    private void appendRemaining(StringBuilder ans, int[] freq) {

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                ans.append((char) ('a' + i));
                freq[i]--;
            }
        }
    }
}