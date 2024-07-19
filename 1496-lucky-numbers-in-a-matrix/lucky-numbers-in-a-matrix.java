class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> minList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int min = matrix[i][0];
            for(int j=0; j<m; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            minList.add(min);
        }
        for(int i=0; i<m; i++) {
            int max = matrix[0][i];
            for(int j=0; j<n; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            maxList.add(max);
        }
        minList.retainAll(maxList);
        return minList;
    }
}