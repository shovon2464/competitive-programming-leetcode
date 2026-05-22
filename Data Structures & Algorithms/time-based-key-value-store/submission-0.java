class TimeMap {

    Map<String, List<String[]>> tracker;
    public TimeMap() {
        this.tracker = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        tracker.computeIfAbsent(key, k -> new ArrayList<>()).add(new String[]
        {value, String.valueOf(timestamp)});
    }
    
    public String get(String key, int timestamp) {
        List<String[]> values = tracker.get(key);

        if (values == null) return "";

        int left = 0;
        int right = values.size() - 1;

        int answer =  - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (Integer.parseInt(values.get(mid)[1]) <= timestamp) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (answer == -1) {
            return "";
        }

        return values.get(answer)[0];
    }
}
