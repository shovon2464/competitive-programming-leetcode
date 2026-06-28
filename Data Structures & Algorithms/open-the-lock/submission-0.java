class Solution {

    public List<String> findChildren(String com) {
        List<String> children = new ArrayList<>();
        char[] charArr = com.toCharArray();
        for (int i = 0; i < 4; i ++) {
            int v = charArr[i] - '0';
            int pm = (v + 1) % 10;
            int nm = (v - 1 + 10) % 10;
            char temp = charArr[i];
            charArr[i] = (char) (pm + '0');
            children.add(new String(charArr));
            charArr[i] = (char) (nm + '0');
            children.add(new String(charArr));
            charArr[i] = temp;
        }
        return children;
    }
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int level = 0;

        while (!queue.isEmpty()) {
            level ++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i ++) {
                String com = queue.poll();
                for (String child : findChildren(com)) {
                    if (child.equals(target)) return level;
                    if (visited.contains(child)) continue;
                    visited.add(child);
                    queue.offer(child);
                }
            }
        }

        return -1;
    }
}