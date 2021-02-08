class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max_sum = 0;
        int min_sum = 0;
        int res = 0;
        for (int num: nums) {
            max_sum = Math.max(num, max_sum + num);
            min_sum = Math.min(num, min_sum + num);
            res = Math.max(res,Math.max(max_sum, Math.abs(min_sum)));
        }
        return res;
    }
}
