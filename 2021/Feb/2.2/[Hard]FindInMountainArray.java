/**
 * https://leetcode.com/problems/find-in-mountain-array/
 * 
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeakIndex(mountainArr);
        int res = binaryLeftSearch(target, mountainArr, 0, peakIndex);
        if (res != -1) return res;
        res = binaryRightSearch(target, mountainArr, peakIndex, mountainArr.length() - 1);
        return res;
    }
    
    private int findPeakIndex(MountainArray mountainArr) {
        int left = 0;
        int length = mountainArr.length();
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    
    private int binaryLeftSearch(int target, MountainArray mountainArr, int left, int right) {
        int start = left;
        int end = right;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) return mid;
            else {
                if (midVal < target) left = mid + 1;
                else right = mid - 1;
            }
        }
        if (left <= end && mountainArr.get(left) == target) return left;
        else if (right >= start && mountainArr.get(right) == target) return right;
        return -1;
    }
    
    private int binaryRightSearch(int target, MountainArray mountainArr, int left, int right) {
        int start = left;
        int end = right;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) return mid;
            else {
                if (midVal < target) right = mid - 1;
                else left = mid + 1;
            }
        }
        if (left <= end && mountainArr.get(left) == target) return left;
        else if (right >= start && mountainArr.get(right) == target) return right;
        return -1;
    }
}