class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        dp[0][0] = 1;
        for(int i = 0; i < m; i++) for(int j = 0; j < n; j++) {
            dp[i + 1][j] += dp[i][j];
            dp[i][j + 1] += dp[i][j];
        }
        return dp[m - 1][n - 1];
    }
}