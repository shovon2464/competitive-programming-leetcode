class Solution {
    public String simplifyPath(String path) {
        String[] strArr = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String str : strArr) {
            if (str.equals("") || str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}