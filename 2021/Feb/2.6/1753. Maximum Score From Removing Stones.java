class Solution {
    public int maximumScore(int a, int b, int c) {
        int[] list = new int[]{a, b, c};
        Arrays.sort(list);
        a = list[0];
        b = list[1];
        c = list[2];
        if (a + b <= c) return a + b;
        int count = 0;
        while (b + c > a && b > 0) {
            count++;
            c--;
            b--;
        }
        return count + b + c;
    }
}