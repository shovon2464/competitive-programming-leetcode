class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        System.out.println(sb.toString());
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
            } else {
                String sizeStr = sb.toString();
                sb.setLength(0);
                int size = Integer.parseInt(sizeStr);
                i ++;
                for (int j = 0; j < size; j ++) {
                    sb.append(str.charAt(i));
                    i ++;
                }
                String tempStr = sb.toString();
                sb.setLength(0);
                result.add(tempStr);
            }
        }

        return result;
    }
}
