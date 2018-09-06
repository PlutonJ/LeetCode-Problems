class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length, dp[][] = new int[m + 1][n + 1];
        dp[0][0] = 1 - obstacleGrid[m - 1][n - 1];
        for(int i = 0; i < m; i++) for(int j = 0; j < n; j++) {
            dp[i + 1][j] += (1 - obstacleGrid[i][j]) * dp[i][j];
            dp[i][j + 1] += (1 - obstacleGrid[i][j]) * dp[i][j];
        }
        return dp[m - 1][n - 1];
    }
}