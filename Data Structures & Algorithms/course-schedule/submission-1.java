class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.adj = new HashMap<>();
        this.visited = new HashSet<>();
        for (int i = 0; i < numCourses; i ++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
        }

        for (int i = 0; i < numCourses; i ++) {
            if (!dfs(i)) return false;
        }

        return true;
    }

    public boolean dfs(int course) {
        if (visited.contains(course)) return false;
        if (adj.get(course).size() == 0) return true;

        visited.add(course);
        for (int n : adj.get(course)) {
            if (!dfs(n)) return false;
        }

        visited.remove(course);
        adj.put(course, new ArrayList<>());
        return true;
    }
}
