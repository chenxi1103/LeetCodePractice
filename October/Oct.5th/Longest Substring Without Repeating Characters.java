// Solution 1 (滑动窗口 + boolean mark [和hashset一个道理但是更好一点])
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] marked = new boolean[256];
        int start = 0, end = 0, result = 0;
        while (start <= end && end < s.length()) {
            if (!marked[s.charAt(end)]) {
                marked[s.charAt(end++)] = true;
                result = Math.max(result, end - start);
            } else {
                marked[s.charAt(start++)] = false;
            }
        }
        return result;
    }
}

// Solution 2 (滑动窗口 + hashset)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, result = 0;
        Set<Character> set = new HashSet<>();
        while (start <= end && end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                result = Math.max(result, end - start);
            } else {
                set.remove(s.charAt(start++));
            }
        }
        return result;
    }
}

// Solution 3 (滑动窗口进阶版 - 好烦第一反应可能想不到)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int index = 0, end = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                //index取两者更大的那个值因为取较小值会有一个duplicate
                index = Math.max(map.get(s.charAt(end)), index);
            }
            result = Math.max(result, end - index + 1);
            //更新index
            map.put(s.charAt(end), ++end);
        }
        return result;
    }
}