class Solution {
    Map<Character,List<Character>> adj;
    Map<Character, Boolean> visited;
    StringBuilder result;
    public boolean dfs(Character node) {
      if (visited.containsKey(node)) {
        return visited.get(node);
      }
      visited.put(node, true);

      for(Character neighbor : adj.get(node)) {
        if(dfs(neighbor)) return true;
      }
      result.append(node);
      visited.put(node, false);
      return false;
    }
    public String foreignDictionary(String[] words) {
      int N = words.length;
      this.adj = new HashMap<>();
      this.visited = new HashMap<>();
      this.result = new StringBuilder();

      for (String word : words) {
        for (Character c : word.toCharArray()) {
          adj.put(c, new ArrayList<>());
        }
      }

      for (int i = 0; i < N - 1; i++) {
        String word1 = words[i];
        String word2 = words[i+1];

        if (word1.length() > word2.length() && word1.startsWith(word2)) {
          return "";
        }

        int minLen = Math.min(word1.length(), word2.length());
        for (int j = 0; j < minLen; j++) {
          if (word1.charAt(j) != word2.charAt(j)) {
            adj.get(word1.charAt(j)).add(word2.charAt(j));
            break;
          }
        }
      }

      for (Character c : adj.keySet()) {
        for (Character v : adj.get(c)) {
          System.out.println(c + "->" + v);
        }
      }

      for (Character c : adj.keySet()) {
        if(dfs(c)) return "";
      }

      result.reverse();
      return result.toString();

    }
}
