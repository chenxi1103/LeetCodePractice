/**
 * 一个一看就知道得用dp但是又有点迷惑写不对的题。。。
 * share一波经典dp题在今天folder里～
 * 看到square你要想到(i-1,i-1)这个点，因为只有它是1，你是1，才有可能变成更大的square，只要有一个不是1，这个sqaure就不能变大
 * row和col = 0的时候没有邻居，所以自己多大，memo里的值就多大
 * 从row=1，col=1开始，如果它本身是0，那就0分滚粗
 * 如果是1，是有可能构成更大的square的，看它的👆，👈，还有i-1, i-1。Min(👆，👈，斜上) + 1是当前这个点所能构成的square的边长
 * 用result记录这个边长，并更新最大值
 * 最后返回边长 * 边长
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 
        int[][] memo = new int[matrix.length][matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) memo[i][j] = matrix[i][j] == '0' ? 0 : 1;
                else memo[i][j] = matrix[i][j] == '0' ? memo[i][j] = 0 : Math.min(Math.min(memo[i][j-1], memo[i-1][j]), memo[i-1][j-1]) + 1;
                result = Math.max(result, memo[i][j]);
            } 
        }
        return result * result;
    }
}