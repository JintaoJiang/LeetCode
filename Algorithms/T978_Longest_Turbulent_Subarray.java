class Solution {
    public int maxTurbulenceSize(int[] A) {
        int res = 1, up = 1, down = 1;
        for(int i = 1; i < A.length; i++){
            if((i % 2 == 1 && A[i] > A[i - 1]) || (i % 2 == 0 && A[i] < A[i - 1])){
                up++;
                down = 1;
            }else if((i % 2 == 1 && A[i] < A[i - 1]) || (i % 2 == 0 && A[i] > A[i - 1])){
                down++;
                up = 1;
            }else{
                up = 1;
                down = 1;
            }
            res = Math.max(res, Math.max(up, down));
        }
        return res;
    }
}