### 28. Implement strStr() [easy] [rabin-karp]
```java
class Solution {
    long modulus = (long)Math.pow(2, 31);
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        if (needle.length() == 0) return 0;
        int hashNeedle = hashCode(needle, 0, needle.length());
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && hashCode(haystack, i, i + needle.length()) == hashNeedle) return i;
        }
        return -1;
    }
    
    private int hashCode(String str, int start, int end) {
        long hashCode = 0;
        while (start != end) {
            hashCode = (hashCode * 31 + str.charAt(start) - 'a') % modulus;
            start++;
        }
        return (int)hashCode;
    }
}
```
##  LeetCode Curated Algo 170
### 604. Design Compressed String Iterator [easy]
```java
class StringIterator {
    Queue<Character> queue = new LinkedList<>();
    List<Integer> list = new ArrayList<>();
    public StringIterator(String compressedString) {
        for (int i = 0; i < compressedString.length(); i++) {
            if (Character.isLetter(compressedString.charAt(i))) queue.add(compressedString.charAt(i));
            else {
                StringBuilder sb = new StringBuilder();
                while (i < compressedString.length() && !Character.isLetter(compressedString.charAt(i))) {
                    sb.append(compressedString.charAt(i));
                    i++;
                }
                list.add(Integer.parseInt(sb.toString()));
                i--;
            }
        }
    }
    
    public char next() {
        if (queue.isEmpty()) return ' ';
        if (list.get(0) == 1) {
            list.remove(0);
            return queue.poll();
        } else {
            int newTime = list.get(0) - 1;
            list.remove(0);
            list.add(0, newTime);
            return queue.peek();
        }
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
```

### 422. Valid Word Square [easy]
```java
class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words.size() != words.get(0).length()) return false;
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (word.length() > words.get(0).length()) return false;
            for (int j = i+1; j < words.get(0).length(); j++) {
                if (j >= word.length()) {
                    if (words.get(j).length() > i) return false;
                } else {
                    char c = word.charAt(j);
                    if (j >= words.size() || words.get(j).length() <= i || words.get(j).charAt(i) != c) return false;
                }
            }
        }
        return true;
    }
}
```