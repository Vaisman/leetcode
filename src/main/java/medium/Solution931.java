package medium;

public class Solution931 {
    public int minFallingPathSum(int[][] A) {
        int x = A.length;
        int y = A[0].length;

        // DP matrix has 2 extra columns
        int[][] dp = new int[x][y + 2];

        // Fill the first row of DP matrix
        for (int i = 1; i <= y; i++) {
            dp[0][i] = A[0][i - 1];
        }

        // Fill Integer.MAX_VALUE into first and last column of DP matrix
        for (int i = 0; i < x; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][y + 1] = Integer.MAX_VALUE;
        }

        // Building the DP matrix
        for (int i = 1; i < x; i++) {
            for (int j = 1; j <= y; j++) {
                // Find the minimum neighbor from previous row in DP matrix
                int minNeighbor = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                minNeighbor = Math.min(minNeighbor, dp[i - 1][j + 1]);
                dp[i][j] = A[i][j - 1] + minNeighbor;
            }
        }

        // The minimum path sum is minimum of the last row in DP matrix
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= y; i++) {
            min = Math.min(min, dp[x - 1][i]);
        }
        return min;
    }
}
