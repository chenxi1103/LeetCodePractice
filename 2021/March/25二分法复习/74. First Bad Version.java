public class Solution {
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int start = 0;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) end = mid;
            else start = mid;
        }
        if(SVNRepo.isBadVersion(start)) return start;
        return end;
    }
}