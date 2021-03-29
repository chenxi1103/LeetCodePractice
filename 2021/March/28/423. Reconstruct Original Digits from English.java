class Solution {
    Map<Integer, String> map = new HashMap<>();
    public String originalDigits(String s) {
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        
        int[] memo = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            memo[s.charAt(i) - 'a']++;
        }
        int[] res = new int[10];
        helper(memo, res, 'z', 0);
        helper(memo, res, 'w', 2);
        helper(memo, res, 'u', 4);
        helper(memo, res, 'x', 6);
        helper(memo, res, 'g', 8);
        helper(memo, res, 'o', 1);
        helper(memo, res, 'h', 3);
        helper(memo, res, 'f', 5);
        helper(memo, res, 's', 7);
        helper(memo, res, 'i', 9);
        
        return constructDigit(res);
    }
    
    
    
    private void helper(int[] memo, int[] res, char c, int num) {
        while (memo[c - 'a'] > 0) {
            res[num]++;
            for (char i : map.get(num).toCharArray()) {
                memo[i - 'a']--;
            }
        }
    }
    
    private String constructDigit(int[] res) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            while (res[i] != 0) {
                sb.append(i + "");
                res[i]--;
            }
        }
        return sb.toString();
    }
    
}