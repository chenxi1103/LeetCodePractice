/**
 * 这个题真的给爷整晕了。。。
 * 这种二维甚至三维的绕来绕去的题我真的很迷所以，就用了挺暴力的解法来解。。。
 * 虽然暴力，但是由于没有开辟新的空间，也只是遍历了一遍整个数组，所以时间空间复杂度都可以说很优秀了
 * 用一个direction来记录现在的方向：1.👉，2.👇，3.👈，4.👆
 * 用rStart ~ rEnd作为row的boundary， cStart ~ cEnd作为col的boundary
 * 每次走完一个方向记得更新boundary
 * 直到list的size和matrix的size一样时，说明整个matrix就走完啦，就可以跳出while loop，return！
 * Runtime: faster than 100.00%
 * Memory: less than 91.62%
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list; 
        int rStart = 0;
        int rEnd = matrix.length - 1;
        int cStart = 0;
        int cEnd = matrix[0].length - 1;
        int direction = 1;
        while (list.size() != matrix.length * matrix[0].length) {
            if (direction == 1) {
                for (int i = cStart; i <= cEnd; i++) {
                    list.add(matrix[rStart][i]);
                }
                rStart++;
                direction = 2;
                continue;
            } else if (direction == 2) {
                for (int i = rStart; i <= rEnd; i++) {
                    list.add(matrix[i][cEnd]);
                }
                cEnd--;
                direction = 3;
                continue;
            } else if (direction == 3) {
                for (int i = cEnd; i >= cStart; i--) {
                    list.add(matrix[rEnd][i]);
                }
                rEnd--;
                direction = 4;
                continue;
            } else {
                for (int i = rEnd; i >= rStart; i--) {
                    list.add(matrix[i][cStart]);
                }
                cStart++;
                direction = 1;
            }
        }
        return list;
    }
}