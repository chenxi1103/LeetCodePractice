class Solution {
    public int minimumLength(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char c = s.charAt(start);
            if (s.charAt(end) != c) return end - start + 1;
            while (start < s.length() && s.charAt(start) == c) start++;
            while ( end > 0 && s.charAt(end) == c) end--;
            if (start > end) return 0;
        }
        return end - start + 1;
    }
}