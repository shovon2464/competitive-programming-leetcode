class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<int[]> deque = new ArrayDeque<>();
        int[] result = new int[n - k + 1];

        int left = 0;
        for (int right = 0; right < n; right ++) {
            while (!deque.isEmpty() && deque.peekLast()[1] <= nums[right]) {
                deque.removeLast();
            }
            deque.offerLast(new int[] {right, nums[right]});

            if (right - left + 1 == k) {
                result[left] = deque.peekFirst()[1];

                if (deque.peekFirst()[0] == left) {
                    deque.removeFirst();
                }
                left ++;
            }
        }

        return result;
    }
}
