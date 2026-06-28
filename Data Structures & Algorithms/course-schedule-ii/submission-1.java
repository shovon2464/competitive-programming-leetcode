class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> visited;
    Set<Integer> visiting;
    List<Integer> result;
    public boolean dfs(int course) {
        if (visiting.contains(course)) return false;
        if (visited.contains(course)) return true;

        visiting.add(course);
        for (int n : adj.get(course)) {
            if (!dfs(n)) return false;
        }

        visiting.remove(course);
        visited.add(course);
        result.add(course);
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.adj = new HashMap<>();
        this.visited = new HashSet<>();
        this.visiting = new HashSet<>();
        this.result = new ArrayList<>();

        for (int i = 0; i < numCourses; i ++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
        }

        for (int i = 0; i < numCourses; i ++) {
            if (!dfs(i)) return new int[0];
        }

        int[] resultArr = new int[result.size()];
        for (int i = 0; i < resultArr.length; i ++) {
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }
}
