class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < arr.length; right ++) {
            result.add(arr[right]);
            if (right - left + 1 > k) {
                int le = arr[left];
                int re = arr[right];

                if (Math.abs(le - x) > Math.abs(re - x)) {
                    result.removeFirst();
                    left ++;
                } else {
                    result.removeLast();
                }
            }
        }

        return result;
    }
}