//一看就会想到dp的题
class Solution {
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        int[] memo = new int[s.length() + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            //只要不是0，都可以沿用上一个数的count
            if (s.charAt(i) != '0') {
                memo[i+1] = memo[i];
            } else {
                //如果出现30/40/50/60/70/80/90/00，直接返回0，不合法
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') return 0;
            }
            //如果满足10～26， count再加上i-1的值
            int twoDigit = Integer.parseInt(String.valueOf(s.substring(i-1, i+1)));
            if (twoDigit >= 10 && twoDigit <= 26) {
                memo[i+1] += memo[i-1];
            }
        }
        return memo[s.length()];
  