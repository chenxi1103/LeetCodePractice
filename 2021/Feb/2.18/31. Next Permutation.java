class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i+1]) {
                int candidateIndex = findIndex(nums, i);
                int temp = nums[i];
                nums[i] = nums[candidateIndex];
                nums[candidateIndex] = temp;
                Arrays.sort(nums, i+1, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
        return;
    }
    
    private int findIndex(int[] nums, int index) {
        int target = nums[index];
        int res = index + 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > target && nums[res] > nums[i]) {
                res = i;
            }
        }
        return res;
    }
}