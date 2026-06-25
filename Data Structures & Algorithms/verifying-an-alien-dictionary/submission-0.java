class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i ++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i ++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            for (int j = 0; j < w1.length(); j ++) {
                if (j == w2.length()) return false;

                if (w1.charAt(j) != w2.charAt(j)) {
                    int o1 = orderMap.get(w1.charAt(j));
                    int o2 = orderMap.get(w2.charAt(j));
                    if (o1 > o2) return false;
                    break;
                }
            }
        }

        return true;
    }
}