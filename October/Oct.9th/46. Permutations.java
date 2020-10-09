/**
 * 一道贼经典的排列组合题了
 * 见排列组合就是老dfs了，模版都应该记住的那种
 * share一波排列组合题的笔记在今天folder里～
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        dfs(list.size(), list, result, 0);
        return result;
    }
    private void dfs(int n, List<Integer> entry, List<List<Integer>> result, int index) {
        // 递归的出口
        if (index == n) result.add(new ArrayList<Integer>(entry));
        for (int i = index; i < n; ++i) {
            Collections.swap(entry, index, i);
            dfs(n, entry, result, index + 1);
            // backtrack再换回来
            Collections.swap(entry, index, i);
        } 
    }
}