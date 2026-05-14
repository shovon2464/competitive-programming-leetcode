class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int prevTop = stack.peek();
                stack.push(top);
                stack.push(top + prevTop);
            } else if (op.equals("D")) {
                int top = stack.peek();
                stack.push(top * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}