class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int minWindowSize = Integer.MAX_VALUE;
        int minWindowStart = 0;
        int matchCount = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right ++) {
            char r = s.charAt(right);
            sMap.put(r, sMap.getOrDefault(r, 0) + 1);
            if (tMap.containsKey(r) && tMap.get(r).intValue() == sMap.get(r).intValue()) {
                matchCount ++;
            }
            while (matchCount == tMap.size()) {
                if (right - left + 1 < minWindowSize) {
                    minWindowSize = right - left + 1;
                    minWindowStart = left;
                }
                char l = s.charAt(left);
                sMap.put(l, sMap.get(l) - 1);
                if (tMap.containsKey(l) && sMap.get(l).intValue() < tMap.get(l).intValue()) {
                    matchCount --;
                }
                left ++;
            }
        }

        return minWindowSize == Integer.MAX_VALUE 
        ? ""
        : s.substring(minWindowStart, minWindowStart + minWindowSize);
    }
}
