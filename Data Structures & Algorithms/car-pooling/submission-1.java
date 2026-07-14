class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] passCng = new int[1001];
        for (int[] trip : trips) {
            passCng[trip[1]] += trip[0];
            passCng[trip[2]] -= trip[0];
        }
        int curPass = 0;
        for (int i = 0; i < 1001; i ++) {
            curPass += passCng[i];
            if (curPass > capacity || curPass < 0) {
                return false;
            }
        }
        return true;
    }
}