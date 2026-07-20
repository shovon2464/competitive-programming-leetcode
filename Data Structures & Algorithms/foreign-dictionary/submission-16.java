class Solution {
    Map<Character, Set<Character>> adj;
    Map<Character, Boolean> visited;
    StringBuilder result;

    public boolean dfs(char node) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        visited.put(node, true);
        for (char neighbor : adj.get(node)) {
            if (dfs(neighbor)) return true;
        }

        visited.put(node, false);
        result.append(node);
        return false;
    }

    public String foreignDictionary(String[] words) {
        this.adj = new HashMap<>();
        this.visited = new HashMap<>();
        this.result = new StringBuilder();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.computeIfAbsent(c, key -> new HashSet());
            }
        }    

        for (int i = 0; i < words.length - 1; i ++ ) {
            String w1 = words[i];
            String w2 = words[i + 1];

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int minLen = Math.min(w1.length(), w2.length());
            for (int j = 0; j < minLen; j ++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        for (char k : adj.keySet()) {
            if (dfs(k)) return "";
        }

        result.reverse();
        return result.toString();
    }
}
