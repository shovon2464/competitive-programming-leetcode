class Solution {
    Map<Integer, List<Integer>> adj;
    Map<Integer, Set<Integer>> preMap;

    public Set<Integer> dfs(int course) {
        if (preMap.containsKey(course)) {
            return preMap.get(course);
        }

        Set<Integer> set = new HashSet<>();
        preMap.put(course, set);
        for (int n : adj.get(course)) {
            set.addAll(dfs(n));
        }
        set.add(course);
        return set;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        this.adj = new HashMap<>();
        this.preMap = new HashMap<>();

        for (int i = 0; i < numCourses; i ++) {
            adj.put(i, new ArrayList<>());
        }    

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        for (int i = 0; i < numCourses; i ++) {
            dfs(i);
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            if (preMap.get(query[1]).contains(query[0])) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;

    }
}