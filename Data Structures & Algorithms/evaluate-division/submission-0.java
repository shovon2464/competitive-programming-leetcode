class Solution {
    Map<String, Map<String, Double>> adj;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        this.adj = new HashMap<>();

        for (int i = 0; i < equations.size(); i ++) {
            String s = equations.get(i).get(0);
            String d = equations.get(i).get(1);
            double v = values[i];
            adj.computeIfAbsent(s, key -> new HashMap<>()).put(d, v);
            adj.computeIfAbsent(d, key -> new HashMap<>()).put(s, 1.0 / v);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i ++) {
            String s = queries.get(i).get(0);
            String d = queries.get(i).get(1);

            if (!adj.containsKey(s) || !adj.containsKey(d)) {
                result[i] = - 1.0;
            } else if (s.equals(d)) {
                result[i] = 1.0;
            } else {
                result[i] = bfs(s, d);
            }
        }

        return result;
    }

    public double bfs(String s, String d) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Double> divMap = new HashMap<>();
        queue.offer(s);
        divMap.put(s, 1.0);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            double currentDiv = divMap.get(current);
            for (Map.Entry<String, Double> entry : adj.get(current).entrySet()) {
                String neighbor = entry.getKey();
                double neighborDiv = entry.getValue();
                
                if (divMap.containsKey(neighbor)) continue;

                double resultDiv = neighborDiv * currentDiv;

                if (neighbor.equals(d)) return resultDiv;

                queue.offer(neighbor);
                divMap.put(neighbor, neighborDiv);
            }
        }

        return - 1.0;
    }
}