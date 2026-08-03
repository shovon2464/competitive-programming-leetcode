class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        for (int i = 0; i < senate.length(); i ++) {
            if (senate.charAt(i) == 'R') {
                rQueue.offer(i);
            } else {
                dQueue.offer(i);
            }
        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int rIdx = rQueue.poll();
            int dIdx = dQueue.poll();

            if (rIdx < dIdx) {
                rQueue.offer(rIdx + senate.length());
            } else {
                dQueue.offer(dIdx + senate.length());
            }
        }
            
        return rQueue.size() > 0 ? "Radiant" : "Dire";
    }
}