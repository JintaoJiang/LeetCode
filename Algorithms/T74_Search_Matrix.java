class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length; if(n == 0) return false;
        int m = matrix[0].length; if(m == 0) return false;
        int lo = 0, hi = n * m - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int row = mid / m, col = mid % m;
            if(matrix[row][col] < target) lo = mid + 1;
            else hi = mid;
        }
        int row = lo / m, col = lo % m;
        return matrix[row][col] == target;
    }
}