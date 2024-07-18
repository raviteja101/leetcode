class LRUCache {

    Map<Integer, Integer> map;
    List<Integer> list;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove(Integer.valueOf(key));
            list.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(Integer.valueOf(key));
        } else if (map.size() == capacity) {
            int n = list.get(0);
            list.remove(0);
            map.remove(n);
        }
        list.add(key);
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */