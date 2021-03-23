/**
 * 最近想集中复习一下dfs（不对应该是重新理解？？？
 */
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int parent = ppid.get(i);
            map.putIfAbsent(parent, new ArrayList<>());
            map.get(parent).add(pid.get(i));
        }
        List<Integer> list = new ArrayList<>();
        list.add(kill);
        dfs(list, map, kill);
        return list;
    }
    
    private void dfs(List<Integer> childProcess, Map<Integer, List<Integer>> map, int kill) {
        if (!map.containsKey(kill)) {
            return;
        }
        for (int id : map.get(kill)) {
            childProcess.add(id);
            dfs(childProcess, map, id);
        }
    }
}