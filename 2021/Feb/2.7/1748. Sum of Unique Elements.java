class Solution {
    public int sumOfUnique(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int res = 0;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1] && !flag) res+= nums[i-1];
            else if (nums[i] != nums[i-1] && flag) flag = false;
            else flag = true;
        }
        if (nums[nums.length-1] != nums[nums.length-2] && !flag) res += nums[nums.length-1];
        return res;
    }
}