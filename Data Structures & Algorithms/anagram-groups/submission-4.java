class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            int[] tracker = new int[26];
            for (char c : str.toCharArray()) {
                int idx = c - 'a';
                tracker[idx] ++;
            }
            String key = stringify(tracker);
            groups.computeIfAbsent(key, k -> new ArrayList()).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
    public String stringify(int[] tracker) {
        StringBuilder sb = new StringBuilder();
        for (int num : tracker) {
            sb.append(num);
            sb.append("#");
        }
        return sb.toString();
    }
}
