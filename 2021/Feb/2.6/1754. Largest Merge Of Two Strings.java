//https://leetcode.com/contest/weekly-contest-227/problems/largest-merge-of-two-strings/
class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        while(word1.length() != 0 && word2.length() != 0) {
            if(word1.charAt(0) > word2.charAt(0)) {
                sb.append(word1.charAt(0));
                word1 = word1.substring(1);
            } else if (word1.charAt(0) < word2.charAt(0)) {
                sb.append(word2.charAt(0));
                word2 = word2.substring(1);
            } else {
                int index = 0;
                boolean flag = false;
                while (index < word1.length() && index < word2.length()) {
                    if (word1.charAt(index) == word2.charAt(index)) index++;
                    else {
                        if (word1.charAt(index) < word2.charAt(index)) flag = true;
                        break;
                    }
                }
                if (flag || (!flag && index == word1.length())) {
                    sb.append(word2.charAt(0));
                    word2 = word2.substring(1);
                } else {
                    sb.append(word1.charAt(0));
                    word1 = word1.substring(1);
                }
            }
        }
        
        if (word1.length() != 0) sb.append(word1);
        if (word2.length() != 0) sb.append(word2);
        return sb.toString(); 
    }
}