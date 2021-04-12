##  LeetCode Curated Algo 170
### 1228. Missing Number In Arithmetic Progression [easy]
```java
class Solution {
    public int missingNumber(int[] arr) {
        int interval = Math.abs(arr[1] - arr[0]);
        for (int i = 2; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i-1]) > interval) return arr[i-1] + arr[1] - arr[0];
            else if (Math.abs(arr[i] - arr[i-1]) < interval) return arr[0] + arr[i] - arr[i-1];
        }
        return arr[0] + arr[2] - arr[1];
    }
}
```

### 1150. Check If a Number Is Majority Element in a Sorted Array [easy]
```java
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) end = mid;
            else start = mid;
        }
        if (nums[start] != target && nums[end] != target) return false;
        int startIndex = nums[start] == target ? start : end;
        int count = 0;
        while (startIndex < nums.length && nums[startIndex] == target) {
            count++;
            startIndex++;
        }
        return count > nums.length/2;
    }
}
```

### 270. Closest Binary Search Tree Value
```java
class Solution {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        double diff = Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if (node.right != null) cur = node.right;
            if (Math.abs(node.val - target) < diff) {
                diff = Math.abs(node.val - target);
                closest = node.val;
            } else return closest;
        }
        return closest;
    }
}
```

### 1056. Confusing Number [easy]
```java
class Solution {
    public boolean confusingNumber(int N) {
        if (N == 0) return false;
        int newN = 0;
        int i = 0;
        int prevN = N;
        while (N != 0) {
            int cur = N % 10;
            if (cur == 2 || cur == 3 || cur == 4 || cur == 5 || cur == 7) return false;
            else {
                newN *= 10;
                if (cur == 6) newN += 9;
                else if (cur == 9) newN += 6;
                else newN += cur;
            }
            N = N/10;
        }
        return newN != prevN;
    }
}
```

### 716. Max Stack [easy]
```java
class MaxStack {

    /** initialize your data structure here. */
    Stack<Integer> maxStack;
    Stack<Integer> stack;
    public MaxStack() {
        maxStack = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (maxStack.isEmpty() || maxStack.peek() <= x) {
            maxStack.push(x);
        } else {
            maxStack.push(maxStack.peek());
        }
        stack.push(x);
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int curMax = maxStack.peek();
        Stack<Integer> temp = new Stack();
        while (stack.peek() != curMax) {
            temp.push(pop());
        }
        pop();
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return curMax;
    }
}
```