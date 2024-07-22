class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] result = new int[n][m];
        int i=0, j=0;

        while(i < n && j < m) {
            int value = Math.min(rowSum[i], colSum[j]);
            result[i][j] = value;
            rowSum[i] -= value;
            colSum[j] -= value;
            if(rowSum[i] == 0) {
                i++;
            }
            if(colSum[j] == 0) {
                j++;
            }
        }

        return result;
    }
}