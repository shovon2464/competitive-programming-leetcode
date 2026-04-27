class Solution {
    Map<Character, List<Character>> aL;
    Map<Character, Boolean> visited;
    StringBuilder result;
    public String foreignDictionary(String[] words) {
      this.aL = new HashMap<>();
      this.visited = new HashMap<>();
      this.result = new StringBuilder();
      int N = words.length;
    
      for (String word : words) {
        for (Character c : word.toCharArray()) {
            aL.computeIfAbsent(c, key -> new ArrayList<>());
        }
      }

      for (int i = 0; i < N - 1; i++) {
        String word1 = words[i];
        String word2 = words[i+1];
        if (word1.length() > word2.length() && word1.startsWith(word2)) {
            return "";
        }
        int minLength = Math.min(word1.length(), word2.length());

        for (int j = 0; j < minLength; j++) {
            if (word1.charAt(j) != word2.charAt(j)) {
                aL.get(word1.charAt(j)).add(word2.charAt(j));
            }
        }
      }

      for (Character c : aL.keySet()) {
        if (dfs(c)) return "";
      }

      return result.reverse().toString();
    }

    public boolean dfs(Character c) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }

        visited.put(c, true);

        for (Character neighbor : aL.get(c)) {
            dfs(neighbor);
        }

        visited.put(c, false);
        result.append(c);
        return false;
    }
}
