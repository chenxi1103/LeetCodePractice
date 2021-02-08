//https://leetcode.com/problems/happy-number/
class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            n = getSumSquare(n);
            if (n == 1) return true;
            if (set.contains(n)) return false;
            else set.add(n);
        }
        return true;
    }
    
    private int getSumSquare(int n) {
        int res = 0;
        while (n != 0) {
            int i = n % 10;
            res += i * i;
            n = n / 10;
        }
        return res;
    }
}