class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        wordList.add(beginWord);

        Map<String, List<String>> adj = new HashMap<>();
        for (String word : wordList) {
            char[] charArr = word.toCharArray();
            for (int i = 0; i < charArr.length; i ++) {
                char temp = charArr[i];
                charArr[i] = '*';
                String com = new String(charArr);
                adj.computeIfAbsent(com, key -> new ArrayList<>()).add(word);
                charArr[i] = temp;
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            level ++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i ++) {
                String current = queue.poll();
                char[] charArr = current.toCharArray();
                for (int j = 0; j < charArr.length; j ++) {
                    char temp = charArr[j];
                    charArr[j] = '*';
                    String com = new String(charArr);
                    charArr[j] = temp;
                    List<String> neighbors = adj.getOrDefault(com, new ArrayList<>());
                    for (String neighbor : neighbors) {
                        if (neighbor.equals(endWord)) return level;
                        if (visited.contains(neighbor)) continue;  
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return 0;
    }
}
