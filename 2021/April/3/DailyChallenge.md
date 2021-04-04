## 1133. Largest Unique Number [easy] [04/03]
```java
class Solution {
    public int largestUniqueNumber(int[] A) {
        if(A == null || A.length == 0) return -1;
        Arrays.sort(A);
        if (A.length == 1) return A[0];
        for (int i = A.length - 1; i > 0; i--) {
            int cur = A[i];
            if (A[i] != A[i-1]) return cur;
            else {
                while (i>= 0 && A[i] == cur) i--;
                i++;
            }
        }
        if(A[0] != A[1]) return A[0];
        return -1;
    }
}
```

## 234. Palindrome Linked List [easy] [04/02]
```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) slow = slow.next;
        slow = reverse(slow);
        return compare(slow, head);
        
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
    private boolean compare(ListNode slow, ListNode head) {
        while(slow != null) {
            if (slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
}
```

## 32. Longest Valid Parentheses [hard] [04/01]
```java
class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i-2] : 0) + 2;
                }
                else if (i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                        dp[i] = dp[i-1] + 2  + (i - dp[i-1] - 2 >= 0 ? dp[i - dp[i-1] - 2] : 0);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
```

## 622. Design Circular Queue [medium] [04/04]
```java
class MyCircularQueue {
    private int[] queue;
    int head = 0;
    int size = 0;
    int tail = -1;
    public MyCircularQueue(int k) {
        queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (size < queue.length) {
            tail = (tail + 1) % queue.length;
            queue[tail] = value;
            size++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if (size == 0) return false;
        queue[head] = 0;
        head = (head + 1) % queue.length;
        size--;
        return true;
    }
    
    public int Front() {
        if (size == 0) return -1;
        return queue[head];
    }
    
    public int Rear() {
        if (size == 0) return -1;
        return queue[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == queue.length;
    }
}
```


