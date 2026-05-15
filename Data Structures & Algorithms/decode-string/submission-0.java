class Solution {
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder patternSB = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    patternSB.insert(0, stack.pop());
                }
                stack.pop();
                String pattern = patternSB.toString();
                StringBuilder numSB = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    numSB.insert(0, stack.pop());
                }
                int num = Integer.parseInt(numSB.toString());
                StringBuilder repeatSB = new StringBuilder();
                for (int i = 0; i < num; i++) {
                    repeatSB.append(pattern);
                }
                stack.push(repeatSB.toString());
            } else {
                stack.push(String.valueOf(c));
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}