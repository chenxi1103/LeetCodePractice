class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // avoid duplicate
            if (i == 0 || (i != 0 && nums[i] != nums[i-1])) {
                int target = nums[i] * -1;
                int start = i + 1;
                int end = nums.length - 1;
                // 相向双指针
                while (start < end) {
                    if (nums[start] + nums[end] == target) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        //注意因为可能有多种答案所以不要直接break，同时也要注意remove duplicate。
                        while (start < end && nums[start] == nums[start+1]) start++;
                        while (start < end && nums[end] == nums[end-1]) end--;
                        start++;
                        end--;
                    } else if (nums[start] + nums[end] < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return result;
    }
}