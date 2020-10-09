/**
 * 相向双指针，谁小谁移动
 * 为什么可以用相向双指针？
 * 因为从两头开始，一定保正有最长的width，但不一定有最高的height
 * 能打败这个情况的只有可能是，短一点的width，高一点的height
 * 此时指针开始移动，肯定是短的一方移动，因为我想找更高的height
 * 所以两个指针就开始相向移动啦，就可以找到最大的答案！
 * Runtime: faster than 95.66%
 * Memory: less than 21.86%
 */
class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int result = 0;
        while (start < end) {
            result = Math.max(result, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) start++;
            else end--;
        }
        return result;
    }
}