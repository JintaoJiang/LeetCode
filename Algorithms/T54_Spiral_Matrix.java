class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList();
        int m = matrix.length;
        if(m == 0) return res;
        int n = matrix[0].length;
        boolean[][] mask = new boolean[m][n];
        int i = 0, j = 0;
        int dir = 0; //right - 0, down - 1, left - 2, up - 3
        while(res.size() < m * n){
            res.add(matrix[i][j]);
            mask[i][j] = true;
            if(dir == 0){
                if(j + 1 >= n || mask[i][j + 1]){ dir = 1; i++; }
                else{ j++; }                   
            }else if(dir == 1){
                if(i + 1 >= m || mask[i + 1][j]){ dir = 2; j--;}
                else{ i++; }
            }else if(dir == 2){
                if(j - 1 < 0 || mask[i][j - 1]){ dir = 3; i--; }
                else{ j--; }                    
            }else{
                if(i - 1 < 0 || mask[i - 1][j]){ dir = 0; j++; }
                else{ i--; }                  
            }
        }
        return res;
    }
}