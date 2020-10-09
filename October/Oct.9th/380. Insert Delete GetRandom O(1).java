/**
 * 这个题。。。啊，大概没有在考algorithm而是在考data structure
 * 想同时满足random（记住每个val的index且能根据index找到value的特性 -> 比如arraylist）
 * 又要满足判断某个object是否已经存在（比如hashmap，hashset）
 * 就只能结合hashmap和arraylist了，这是最不动脑子的方法
 * 总觉得空间复杂度不会很好，果然= =
 * Time: faster than 84.82%
 * Memory: less than 8.74%
 */
class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        else {
            list.add(val);
            map.put(val, list.size() - 1);
        }
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        else {
            int index = map.get(val);
            list.set(index, list.get(list.size() - 1));
            map.put(list.get(list.size() - 1), index);
            map.remove(val);
            list.remove(list.size() - 1);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = (int) Math.floor(Math.random() * Math.floor(list.size()));
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */