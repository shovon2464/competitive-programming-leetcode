class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<strs.size();i++) {
            sb.append(Integer.toString(strs.get(i).length()));
            sb.append("#");
            sb.append(strs.get(i));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        StringBuilder lnStr = new StringBuilder();

        int i = 0;
        while(i<str.length()) {
            char c = str.charAt(i);
            if(Character.isDigit(c)) {
                lnStr.append(c);
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
