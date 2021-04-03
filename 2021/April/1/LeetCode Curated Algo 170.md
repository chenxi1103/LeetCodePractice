## 1134. Armstrong Number
```java
class Solution {
    public boolean isArmstrong(int n) {
        long sum = 0;
        String str = Integer.toString(n);
        for (char c : str.toCharArray()) {
            sum += Math.pow(c - '0', str.length());
        }
        return (int) sum == n;
    }
}
```
