class Solution {
    int[] matchsticks;
    int[] sides;
    int target;
    public boolean makesquare(int[] matchsticks) {
        this.matchsticks = matchsticks;
        this.sides = new int[4];
        int sum = 0;
        for (int m : matchsticks) {
            sum += m;
        }
        if (sum % 4 != 0) return false;
        this.target = sum / 4;
        Arrays.sort(matchsticks);
        for (int l = 0, r = matchsticks.length - 1; l < r; l ++, r --) {
            int temp = matchsticks[l];
            matchsticks[l] = matchsticks[r];
            matchsticks[r] = temp;
        }
        if (matchsticks[0] > target) return false;
        return dfs(0);
    }

    public boolean dfs(int idx) {
        if (idx == matchsticks.length) return true;

        for (int i = 0; i < 4; i ++) {
            if (sides[i] + matchsticks[idx] <= target) {
                sides[i] += matchsticks[idx];
                if (dfs(idx + 1)) return true;
                sides[i] -= matchsticks[idx];
            }
        }

        return false;
    }
}