class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIdx = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            lastIdx.put(s.charAt(i), i);
        }

        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i ++) {
            end = Math.max(end, lastIdx.get(s.charAt(i)));

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
