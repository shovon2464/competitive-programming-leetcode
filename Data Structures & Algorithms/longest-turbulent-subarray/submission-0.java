class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int left = 0;
        int right = 1;
        int longest = 1;
        String prev = "";

        while (right < arr.length) {
            if (arr[right - 1] > arr[right] && !prev.equals(">")) {
                longest = Math.max(longest, right - left + 1);
                right ++;
                prev = ">";
            } else if (arr[right - 1] < arr[right] && !prev.equals("<")) {
                longest = Math.max(longest, right - left + 1);
                right ++;
                prev = "<"; 
            } else {
                if (arr[right - 1] == arr[right]) {
                    right ++;
                }
                left = right - 1;
                prev = "";
            }
        }

        return longest;
    }
}