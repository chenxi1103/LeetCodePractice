public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums[0] <= nums[nums.length - 1]) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[mid]) start = mid;
            else if (nums[end] > nums[mid]) end = mid;
            else break;
        }
        return Math.min(nums[start], nums[end]);
    }
}