class Solution {
    List<List<Integer>> preMap;
    List<Integer> schedule;
    boolean[] visited;
    boolean[] cycle;
    public boolean dfs(int course) {
        if (visited[course]) return true;
        if (cycle[course]) return false;

        cycle[course] = true;
        for (int prerequisite : preMap.get(course)) {
            if (!dfs(prerequisite)) return false;
        }
        cycle[course] = false;
        visited[course] = true;
        schedule.add(course);
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.preMap = new ArrayList<>();
        this.schedule = new ArrayList<>();
        this.visited = new boolean[numCourses];
        this.cycle = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            preMap.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            preMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return new int[]{};
        }

        int[] result = new int[schedule.size()];
        for (int i = 0; i < schedule.size(); i++) {
            result[i] = schedule.get(i);
        }
        return result;
    }
}
