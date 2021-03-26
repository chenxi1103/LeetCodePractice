public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) start = mid;
            else end = mid;
        }
        int res = nums[end] == target ? end : start;
        if (nums[res] != target) return -1;
        return res;
    }
}