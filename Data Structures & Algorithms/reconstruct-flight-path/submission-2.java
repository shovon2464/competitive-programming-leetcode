class Solution {
    Map<String, List<String>> adj;
    List<String> result;
    public void hierHolzer(String node) {
        List<String> neighbors = adj.get(node);

        while (neighbors != null && !neighbors.isEmpty()) {
            hierHolzer(neighbors.remove(neighbors.size() - 1));
        }

        result.add(node);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        this.adj = new HashMap<>();
        this.result = new ArrayList<>();

        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), key -> new ArrayList<>()).add(ticket.get(1));
        }

        for (List<String> value : adj.values()) {
            Collections.sort(value, Collections.reverseOrder());
        }

        hierHolzer("JFK");
        Collections.reverse(result);

        return result;
    }
}
