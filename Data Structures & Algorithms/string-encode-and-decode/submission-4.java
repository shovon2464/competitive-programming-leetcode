class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            if (Character.isDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
                i ++;
            } else if (str.charAt(i) == '#') {
                int num = Integer.parseInt(sb.toString());
                sb.setLength(0);
                i ++;
                for (int j = 0; j < num; j++) {
                    sb.append(str.charAt(i));
                    i ++;
                }
                String word = sb.toString();
                result.add(word);
                sb.setLength(0);
            }
        }

        return result;
    }
}
