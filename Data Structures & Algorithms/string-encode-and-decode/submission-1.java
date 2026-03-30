class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        StringBuilder lnStr = new StringBuilder();

        int i = 0;
        while(i<str.length()) {
            if(Character.isDigit(str.charAt(i))) {
                lnStr.append(str.charAt(i)); 
                i++;
            } else {
                int ln = Integer.parseInt(lnStr.toString());
                lnStr.setLength(0);
                i++;
                for(int j=0;j<ln;j++) {
                    sb.append(str.charAt(i));
                    i++;
                }
                decoded.add(sb.toString());
                sb.setLength(0);
            }
        }
        return decoded;
    }
}
