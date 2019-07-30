class TimeMap {
    Map<String, TreeMap<Integer, String>> data = new HashMap();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> map = data.getOrDefault(key, new TreeMap());
        map.put(timestamp, value);
        data.put(key, map);
    }
    
    public String get(String key, int timestamp) {
        if(!data.containsKey(key)) return "";
        TreeMap<Integer, String> map = data.get(key);
        Integer t = map.floorKey(timestamp);
        if(t == null) return "";
        return map.get(t);
    }
}