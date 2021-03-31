## 26. Remove Duplicates from Sorted Array [Easy]
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int cur = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != cur) {
                nums[++index] = nums[i];
                cur = nums[i];
            }
        }
        return index + 1;
    }
}
```
## 80. Remove Duplicates from Sorted Array II [Medium]
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int index = 0;
        int cur = nums[index];
        int counter = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != cur) {
                nums[++index] = nums[i];
                cur = nums[i];
                counter = 1;
            } else {
                if (counter < 2) {
                    nums[++index] = nums[i];
                    counter++;
                }
            }
        }
        return index + 1;
    }
}
```