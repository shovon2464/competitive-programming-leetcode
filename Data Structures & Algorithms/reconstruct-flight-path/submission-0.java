class Solution {
    Map<String, List<String>> adj;
    List<String> result;
    public void hierholzer(String node) {
        List<String> neighbors = adj.get(node);
        while(neighbors != null && !neighbors.isEmpty()) {
            String neighbor = neighbors.remove(0);
            hierholzer(neighbor);
        }
        result.add(node);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        this.adj = new HashMap<>();
        this.result = new ArrayList<>();

        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), key-> new ArrayList()).add(ticket.get(1));
        }

        for (String key : adj.keySet()) {
            Collections.sort(adj.get(key));
        }

        hierholzer("JFK");
        Collections.reverse(result);
        return result;
    }
}
