class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s1.length(); i ++) {
            int index1 = s1.charAt(i) - 'a';
            arr1[index1] ++;
            int index2 = s2.charAt(i) - 'a';
            arr2[index2] ++;
        }

        int matchCount = 0;

        for (int i = 0; i < arr1.length; i ++) {
            if (arr1[i] == arr2[i]) matchCount ++;
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right ++) {
            if (matchCount == 26) return true;
            
            int leftIndex = s2.charAt(left) - 'a';
            left ++;
            arr2[leftIndex] --;

            if (arr2[leftIndex] + 1 == arr1[leftIndex]) {
                matchCount --;
            } else if (arr2[leftIndex] == arr1[leftIndex]) {
                matchCount ++;
            }

            int rightIndex = s2.charAt(right) - 'a';
            arr2[rightIndex] ++;

            if (arr2[rightIndex] - 1 == arr1[rightIndex]) {
                matchCount --;
            } else if (arr2[rightIndex] == arr1[rightIndex]) {
                matchCount ++;
            }
        }

        return matchCount == 26 ? true : false;
    }
}
