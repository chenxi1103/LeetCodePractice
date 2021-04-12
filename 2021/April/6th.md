## Daily Chanllenge
### 1551. Minimum Operations to Make Array Equal [medium]
```java
class Solution {
    public int minOperations(int n) {
        int i = 0;
        int res = 0;
        while (2 * i + 1 < n) {
            res += (n - (2 * i + 1));
            i++;
        }
        return res;
    }
}
```

