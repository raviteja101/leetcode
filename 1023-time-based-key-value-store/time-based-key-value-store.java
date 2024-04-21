class TimeMap {

    Map<String, TreeMap<Integer, String>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)) {
            hm.put(key, new TreeMap<>());
        }
        hm.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> tm = hm.get(key);
        Integer k = tm.floorKey(timestamp);
        if(k == null) {
            return "";
        }
        return tm.get(k);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */