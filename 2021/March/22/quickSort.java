//今天复习一下quicksort，回忆一下怎么写partition的过程。
//https://leetcode.com/problems/sort-an-array
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums; 
    }
    
    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int p = partition(nums, low, high);
            quickSort(nums, low, p - 1);
            quickSort(nums, p + 1, high);
        }
    }
    
    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return i + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}