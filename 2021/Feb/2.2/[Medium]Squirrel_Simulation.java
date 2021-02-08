//https://leetcode.com/problems/squirrel-simulation/
class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int res = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nuts.length; ++i) {
            int nuts2Tree = getDistance(nuts[i], tree);
            int nuts2Squirrel = getDistance(nuts[i], squirrel);
            diff = Math.min(diff, nuts2Squirrel - nuts2Tree);
            res += nuts2Tree*2;
        }
        return res + diff;
    }
    
    private int getDistance(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }
}
