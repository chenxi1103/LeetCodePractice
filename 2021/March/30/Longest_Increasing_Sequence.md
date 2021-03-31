## 300. Longest Increasing Subsequence
- https://leetcode.com/problems/longest-increasing-subsequence/
- ```java
    public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int[] memo = new int[nums.length];
            memo[0] = 1;
            int res = 1;
            for (int i = 1; i < nums.length; ++i) {
                int maxCount = 1;
                for (int j = i-1; j >= 0; j--) {
                    if (nums[i] > nums[j]) maxCount = Math.max(maxCount, memo[j] + 1);
                }
                memo[i] = maxCount;
                res = Math.max(res, memo[i]);
            }
            return res;
        }
    ```

## 354. Russian Doll Envelopes
- https://leetcode.com/problems/russian-doll-envelopes/
- ```java
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null || envelopes.length == 0) return 0;
            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) return Integer.compare(o2[1], o1[1]);
                    return Integer.compare(o1[0], o2[0]);
                }
            });
            
            int[] heights = new int[envelopes.length];
            for (int i = 0; i < envelopes.length; ++i) {
                heights[i] = envelopes[i][1];
            }
            return LIS(heights);
        }
        
        private int LIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int[] memo = new int[nums.length];
            memo[0] = 1;
            int res = 1;
            for (int i = 1; i < nums.length; ++i) {
                int maxCount = 1;
                for (int j = i-1; j >= 0; j--) {
                    if (nums[i] > nums[j]) maxCount = Math.max(maxCount, memo[j] + 1);
                }
                memo[i] = maxCount;
                res = Math.max(res, memo[i]);
            }
            return res;
        }
    }
    ```
