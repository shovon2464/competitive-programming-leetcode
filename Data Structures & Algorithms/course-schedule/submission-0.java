class Solution {
    Map<Integer, List<Integer>> preMap;
    boolean[] visited;
    public boolean dfs(int course) {
        if (visited[course]) return false;
        if (preMap.get(course).size() == 0) return true;

        visited[course] = true;

        for (int prerequisite : preMap.get(course)) {
            if (!dfs(prerequisite)) return false;
        }

        visited[course] = false;
        preMap.put(course, new ArrayList<>());
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.preMap = new HashMap<>();
        this.visited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            preMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }

        return true;
    }
}
