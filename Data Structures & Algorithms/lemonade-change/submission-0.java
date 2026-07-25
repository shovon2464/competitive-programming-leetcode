class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> tracker = new HashMap<>();

        for (int bill : bills) {
            tracker.put(bill, tracker.getOrDefault(bill, 0) + 1);
            int returnAmount = bill - 5;

            while (returnAmount >= 20 && tracker.containsKey(20) && tracker.get(20) > 0) {
                returnAmount -= 20;
                tracker.put(20, tracker.get(20) - 1);
            }

            while (returnAmount >= 10 && tracker.containsKey(10) && tracker.get(10) > 0) {
                returnAmount -= 10;
                tracker.put(10, tracker.get(10) - 1);
            }

            while (returnAmount >= 5 && tracker.containsKey(5) && tracker.get(5) > 0) {
                returnAmount -= 5;
                tracker.put(5, tracker.get(5) - 1);
            }

            if (returnAmount > 0) return false;
        }

        return true;
    }
}