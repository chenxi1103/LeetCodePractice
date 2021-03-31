## 1165. Single-Row Keyboard [Easy]
```java
class Solution {
    public int calculateTime(String keyboard, String word) {
        if (word == null || word.length() == 0) return 0;
        int[] map = constructKeyboard(keyboard);
        int res = 0;
        int pos = 0;
        for (char c : word.toCharArray()) {
            res += Math.abs(pos - map[c - 'a']);
            pos = map[c - 'a'];
        }
        return res;
    }
    
    private int[] constructKeyboard(String keyboard) {
        int[] map = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            map[keyboard.charAt(i) - 'a'] = i;
        }
        return map;
    }
}
```

## 760. Find Anagram Mappings [easy]
```java
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.putIfAbsent(B[i], new LinkedList<>());
            map.get(B[i]).offer(i);
        }
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = map.get(A[i]).poll();
        }
        return res;
    }
}
```

## 1213. Intersection of Three Sorted Arrays [easy]
```java
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int min = Math.min(arr1[0], Math.min(arr2[0], arr3[0]));
        int max = Math.max(arr1[arr1.length - 1], Math.max(arr2[arr2.length - 1], arr3[arr3.length - 1]));
        
        int[] memo = new int[max - min + 1];
        record(memo, arr1, min);
        record(memo, arr2, min);
        record(memo, arr3, min);
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] == 3) list.add(i + min);
        }
        return list;
    }
    
    private void record(int[] memo, int[] arr, int min) {
        for (int i = 0; i < arr.length; i++) {
            memo[arr[i] - min]++;
        }
    }
}
```

## 1180. Count Substrings with Only One Distinct Letter [Easy]
```java
class Solution {
    public int countLetters(String S) {
        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            int count = 1;
            char c = S.charAt(i);
            for (int j = i + 1; j < S.length(); j++) {
                if (S.charAt(j) == c) count++;
                else break;
            }
            res += count;
        }
        return res;
    }
}
```

## 1086. High Five [Easy]
```java
class Solution {
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int curId = items[0][0];
        int count = 0;
        while (i < items.length) {
            int sum = 0;
            while (count < 5) {
                sum += items[i++][1];
                count++;
            }
            int[] sub = new int[2];
            sub[0] = curId;
            sub[1] = sum/5;
            res.add(sub);
            while (i < items.length && items[i][0] == curId) i++;
            if (i == items.length) break;
            curId = items[i][0];
            count = 0;
        }
        int[][] finalRes = new int[res.size()][2];
        for (int j= 0; j < res.size(); j++) {
            finalRes[j][0] = res.get(j)[0];
            finalRes[j][1] = res.get(j)[1];
        }
        return finalRes;
    }
}
```
