// Comparator sort, 直接暴力好想
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> a[0]*a[0]+a[1]*a[1] - b[0]*b[0] - b[1]*b[1]);
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        return res;
    }
}