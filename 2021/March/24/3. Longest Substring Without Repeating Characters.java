class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int res = 0;
        int[] memo = new int[128];
        if (s == null || s.length() == 0) return 0; 
        while (end < s.length()) {
            char c = s.charAt(end);
            if (memo[c] == 0) {
                memo[c]++;
            } else {
                res = Math.max(res, end - start);
                while (s.charAt(start) != c) {
                    memo[s.charAt(start)]--;
                    start++;
                }
                start++;
            }
            end++;
        }
        return Math.max(res, end - start);
    }
}