//https://leetcode.com/contest/weekly-contest-226/problems/maximum-number-of-balls-in-a-box/
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] mem = new int[45];
        int max = 0;
        for (int i = lowLimit; i <= highLimit; ++i) {
            int boxNum = boxHelper(i) - 1;
            mem[boxNum] += 1;
            max = Math.max(max, mem[boxNum]);
        }
        return max;
    }
    
    private int boxHelper(int num) {
        int boxNum = 0;
        while (num > 0) {
            boxNum += num % 10;
            num /= 10;
        }
        return boxNum;
    }
}