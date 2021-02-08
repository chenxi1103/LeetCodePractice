class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == c) list.add(i);
        }
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            res[i] = getSmallest(i, list);
        }
        return res;
    }
    private int getSmallest(int i, List<Integer> list) {
        int cand = Integer.MAX_VALUE;
        for (int index : list) {
            int temp = Math.abs(index - i);
            if (temp > cand) return cand;
            cand = temp;
        }
        return cand;
    }
}
