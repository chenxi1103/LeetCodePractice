/**
 * 第一次写这个题，看到括号题目会想到stack，但是这道题完全不需要stack。
 * 我的思路是，维护一个count，遍历一遍字符串，考虑以下几种情况
 * 1. 这个字符是字母，保留
 * 2. 这个字符是(，保留
 * 3. 这个字符是)，如果count == 0， 说明之后的字符也不会出现能和它匹配的，丢掉它。
 *               如果count > 0， 前面的一个（可以和它匹配，于是count--
 * 
 * 全遍历完了以后看count是否大于0，大于0说明还有没移除的（，反向遍历，直到移除掉所有的没有匹配的（
 * Runtime: faster than 94.56%
 * Memory: less than 90.77%
 */
class Solution {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                if (count == 0) continue;
                else count--;
            }
            sb.append(s.charAt(i));
        }
        int i = sb.length() - 1;
        while (count != 0 && i >= 0) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                count--;
            }
            i--;
        }
        return sb.toString();
    }
}