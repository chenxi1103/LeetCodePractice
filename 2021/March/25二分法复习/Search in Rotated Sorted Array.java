//解法1:
public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) return -1;
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] < target) {
                if (A[mid] > A[0]) start = mid;
                else {
                    if (target <= A[A.length - 1]) start = mid;
                    else end = mid;
                }

            } else {
                if (A[mid] < A[A.length - 1]) end = mid;
                else {
                    if (target >= A[0]) end = mid;
                    else start = mid;
                }
            }
        }
        int res = A[start] == target ? start : end;
        if (A[res] == target) return res;
        else return -1;
    }
}

//解法2:
public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) return -1;
        if (A[0] <= A[A.length - 1]) return binarySearch(A, target, 0, A.length - 1);
        int minimum = findMinimum(A);
        int maximum = minimum - 1;
        if (A[minimum] > target || A[maximum] < target) return -1;
        if (target > A[0]) return binarySearch(A, target, 0, maximum);
        else return binarySearch(A, target, minimum, A.length - 1);
    }

    private int findMinimum(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[start]) start = mid;
            else if (A[mid] < A[end]) end = mid;
            else break;
        }
        int res = A[start] < A[end] ? start : end;
        return res;
    }

    private int binarySearch(int[] A, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] < target) start = mid;
            else end = mid;
        }
        int res = A[start] == target ? start : end;
        if (A[res] == target) return res;
        return -1;
    }
}