class TimeMap {

    Map<String, List<Integer>> keyTimestamps;
    Map<String, Map<Integer, String>> keyTimestampVals; 

    public TimeMap() {
      keyTimestamps = new HashMap<>();
      keyTimestampVals = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!keyTimestamps.containsKey(key)) keyTimestamps.put(key, new ArrayList<>());
        keyTimestamps.get(key).add(timestamp);

        if(!keyTimestampVals.containsKey(key)) keyTimestampVals.put(key, new HashMap<>());
        keyTimestampVals.get(key).put(timestamp, value);
    }
    
    // public String get(String key, int timestamp) {
    //     if(!keyTimestamps.containsKey(key)) return "";
    //     List<Integer> timestamps = keyTimestamps.get(key);
    //     int lbIdx = lowerBound(timestamps, timestamp + 1);
    //     if(lbIdx >= timestamps.size()) return "";
    //     return keyTimestampVals.get(key).get(timestamps.get(lbIdx - 1));
    // }

    public String get(String key, int timestamp) {
    if (!keyTimestamps.containsKey(key)) return "";

    List<Integer> timestamps = keyTimestamps.get(key);

    int idx = lowerBound(timestamps, timestamp + 1);

    if (idx == 0) return "";

    return keyTimestampVals.get(key).get(timestamps.get(idx - 1));
}

    private int lowerBound(List<Integer> lst, int timestamp) {
        int left = 0, right = lst.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(timestamp <= lst.get(mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
