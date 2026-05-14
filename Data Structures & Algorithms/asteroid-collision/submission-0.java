class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                if (Math.abs(stack.peek()) > Math.abs(a)) {
                    destroyed = true;
                    break;
                } else if (Math.abs(stack.peek()) < Math.abs(a)) {
                    stack.pop();
                } else {
                    stack.pop();
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(a);
            }
        }

        int[] result = new int[stack.size()];
        int i = stack.size() - 1;

        while (!stack.isEmpty()) {
            result[i] = stack.pop();
            i --;
        }

        return result;
    }
}