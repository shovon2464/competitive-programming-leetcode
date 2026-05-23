/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 0;
        int right = n - 1;

        int properMid = right;

        while (left <= right) {
            int m = left + (right - left) / 2;
            int mv = mountainArr.get(m);
            int lv = m - 1 >= 0 ? mountainArr.get(m - 1) : Integer.MIN_VALUE;
            int rv = m + 1 < n ? mountainArr.get(m + 1) : Integer.MAX_VALUE;

            if (mv > lv && mv > rv) {
                properMid = m;
                break;
            } else if (mv > lv) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }

        if (left > right) return - 1;

        if (mountainArr.get(properMid) == target) return properMid;

        left = 0;
        right = properMid - 1;

        while (left <= right) {
            int m = left + (right - left) / 2;
            int mv = mountainArr.get(m);

            if (mv == target) {
                return m;
            } else if (mv < target) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }

        left = properMid - 1;
        right = n - 1;

        while (left <= right) {
            int m = left + (right - left) / 2;
            int mv = mountainArr.get(m);

            if (mv == target) {
                return m;
            } else if (mv < target) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }

        return - 1;
    }
}