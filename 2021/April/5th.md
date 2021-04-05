## Daily Challenge
### 775. Global and Local Inversions [medium]
```java
class Solution {
    public boolean isIdealPermutation(int[] A) {
        boolean flag = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i-1] - A[i] > 1) return false;
            else if (A[i-1] - A[i] == 1) {
                if (flag) return false;
                flag = true;
            } else flag = false;
        }
        return true;
    }
}
```

## LeetCode Curated Algo 170
### 359. Logger Rate Limiter [easy]
```java
class Logger {

    /** Initialize your data structure here. */
    Map<String, Integer> logger;
    public Logger() {
        logger = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if((logger.containsKey(message) && timestamp - logger.get(message) >= 10) || !logger.containsKey(message)) {
            logger.put(message, timestamp);
            return true;
        }
        return false;
    }
}
```

### 1196. How Many Apples Can You Put into the Basket [easy]
```java
class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > 5000) return i;
        }
        return arr.length;
    }
}
```
### 1064. Fixed Point [easy]
```java
class Solution {
    public int fixedPoint(int[] arr) {
        if (arr[0] > 0) return -1;
        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= mid) end = mid;
            else start = mid;
        }
        if (arr[start] == start) return start;
        else if (arr[end] == end) return end;
        return -1;
    }
}
```

### 1065. Index Pairs of a String [easy]
```java
class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(words, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (int j = 0; j < words.length; j++) {
                if (c == words[j].charAt(0)) {
                    if (words[j].length() + i <= text.length() && text.substring(i, i + words[j].length()).equals(words[j])) {
                        int[] subres = new int[2];
                        subres[0] = i;
                        subres[1] = words[j].length() + i - 1;
                        list.add(subres);
                    }
                } 
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
```

### 1099. Two Sum Less Than K [easy]
```java
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums == null || nums.length < 2) return -1;
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int max = Integer.MIN_VALUE;
        while (start + 1 <= end) {
            if (nums[start] + nums[end] >= k) end--;
            else {
                max = Math.max(nums[start] + nums[end], max);
                start++;
            }
        }
        if (max == Integer.MIN_VALUE) return -1;
        return max;
    }
}
```