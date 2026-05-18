class FreqStack {

    Map<Integer, List<Integer>> groups;
    Map<Integer, Integer> seen;
    int maxFreq;
    public FreqStack() {
        this.groups = new HashMap<>();
        this.seen = new HashMap<>();
        this.maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = seen.getOrDefault(val, 0) + 1;
        seen.put(val, freq);
        maxFreq = Math.max(freq, maxFreq);
        groups.computeIfAbsent(freq, key -> new ArrayList<>()).add(val);
    }
    
    public int pop() {
        List<Integer> list = groups.get(maxFreq);
        int val = list.removeLast();
        seen.put(val, seen.get(val) - 1);
        if (list.isEmpty()) {
            groups.remove(maxFreq);
            maxFreq --;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */