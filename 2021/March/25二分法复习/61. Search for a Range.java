public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (A == null || A.length == 0) return res;
        int startIndex = findFirst(A, target, 0, A.length - 1);
        if (startIndex != -1) {
            int endIndex = findLast(A, target, startIndex, A.length - 1);
            res[0] = startIndex;
            res[1] = endIndex;
        }
        return res;
    }

    private int findFirst(int[] A, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) end = mid;
            else start = mid;
        }
        int res = A[start] == target ? start : end;
        if (A[res] != target) return -1;
        return res;
    }

    private int findLast(int[] A, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) start = mid;
            else end = mid;
        }
        int res = A[end] == target ? end : start;
        if (A[res] != target) return -1;
        return res;
    }
}