/**
 * 典型的田忌赛马问题
 * 记住逻辑很简单 - 贪心原则：
 *  1. 选择最小的比当前值大的元素
 *  2. 如果没有比它更大的存在，就用当前所剩最小的那个值跟他比。
 * 
 * 解法：
 * 自己写二分法，找到比当前值大的最小元素，if没有，就返回所剩最小的那个值
 * 
 */
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[] res = new int[A.length];
        boolean[] memo = new boolean[A.length];
        for (int i = 0; i < B.length; ++i) {
            int target = B[i];
            int index = bestIndex(A, memo, target, binarySearch(A, target));
            res[i] = A[index];
            memo[index] = true;
        }
        return res;
    }
    private int binarySearch(int[] A, int target) {
        int left = 0;
        int right = A.length;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (A[mid] < target) left = mid + 1;
            else if (A[mid] == target) return mid;
            else right = mid - 1;
        }
        return left;
    }
    
    private int bestIndex(int[] A, boolean[] memo, int target, int index) {
        while (index < A.length && (memo[index] || A[index] <= target)) {
            index++;
        }
        if (index >= A.length) return getSmallestIndex(A, memo);
        else return index;
    }
    
    private int getSmallestIndex(int[] A, boolean[] memo) {
        for (int i = 0; i < A.length; i++) {
            if (!memo[i]) return i;
        }
        return A.length - 1;
    }
}