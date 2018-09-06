// brute force, +6 for every cube, -2 for every touching face of the added cube

class Solution {
    public int surfaceArea(int[][] grid) {
        if(grid.length == 0) return 0;
        int n = grid.length, cnt = 0, space[][][] = new int[n + 1][n + 1][50 + 1];
        for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) for(int k = 0; k < grid[i][j]; k++) cnt += (space[i + 1][j + 1][k + 1] = 1) * 6 - space[i][j + 1][k + 1] * 2 - space[i + 1][j][k + 1] * 2 - space[i + 1][j + 1][k] * 2;
        return cnt;
    }
}