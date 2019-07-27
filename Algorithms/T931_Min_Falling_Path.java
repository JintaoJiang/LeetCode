class Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length, n = A[0].length;
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                int pre = A[i - 1][j];
                if(j >= 1) pre = Math.min(pre, A[i - 1][j - 1]);
                if(j < n - 1) pre = Math.min(pre, A[i - 1][j + 1]);
                A[i][j] += pre;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.min(res, A[m - 1][i]);
        }
        return res;
    }
}