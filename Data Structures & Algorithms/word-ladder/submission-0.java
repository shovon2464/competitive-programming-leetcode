class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        wordList.add(beginWord);
        Map<String, List<String>> patterns = new HashMap<>();

        for (String word : wordList) {
            char[] charArr = word.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                char temp = charArr[i];
                charArr[i] = '*';
                String pattern = new String(charArr);
                patterns.computeIfAbsent(pattern, key -> new ArrayList<>()).add(word);
                charArr[i] = temp;
            }
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int size = 0;
        while(!queue.isEmpty()) {
            size ++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return size;
                char[] charArr = word.toCharArray();
                for (int j = 0; j < charArr.length; j++) {
                    char temp = charArr[j];
                    charArr[j] = '*';
                    String pattern = new String(charArr);
                    charArr[j] = temp;
                    for (String neighbor : patterns.get(pattern)) {
                        if (visited.contains(neighbor)) continue;
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }

        return 0;
    }
}
