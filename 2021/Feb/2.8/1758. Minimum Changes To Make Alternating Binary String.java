class Solution {
    public int minOperations(String s) {
        char[] charArray = s.toCharArray();
        int res = helper(charArray);
        char[] charArray2 = s.toCharArray();
        charArray2[0] = charArray2[0] == '1' ? '0' : '1';
        int res2 = helper(charArray2) + 1;
        return Math.min(res, res2);
    }
    
    private int helper(char[] charArray) {
        int count = 0;
        char cur = charArray[0];
        for (int i = 1; i < charArray.length; ++i) {
            if (cur == charArray[i]) {
                count++;
                charArray[i] = cur == '1' ? '0' : '1';
            }
            cur = charArray[i];
        }
        return count;
    }
    
}