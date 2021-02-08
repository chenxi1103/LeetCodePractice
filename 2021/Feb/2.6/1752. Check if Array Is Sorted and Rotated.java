//https://leetcode.com/contest/weekly-contest-227/problems/check-if-array-is-sorted-and-rotated/
class Solution {
    public boolean check(int[] nums) {
        if (nums.length == 1) return true;
        int count = 0;
        for(int i = 1; i < nums.length; ++i) {
            if (count > 1) return false;
            if (nums[i-1] > nums[i]) count++;
        }
        if (count > 1) return false;
        if (count == 1) return nums[nums.length - 1] <= nums[0];
        return true;
    }
}
