//对不起我还是想sort噗噗噗
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        List<String> result = new ArrayList<>(map.keySet());
        Collections.sort(result, (a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));
        return result.subList(0, k);
    }
}