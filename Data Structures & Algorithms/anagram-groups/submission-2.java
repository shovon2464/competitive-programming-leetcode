class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] tracker = new int[26];
            for (int i = 0; i < str.length(); i++) {
                int index = (int) str.charAt(i) - 'a';
                tracker[index] ++;
            }
            String key = Arrays.toString(tracker);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> v : map.values()) {
            result.add(v);
        }
        return result;
    }
}
