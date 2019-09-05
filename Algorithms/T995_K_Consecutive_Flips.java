class Solution {
    public int minKBitFlips(int[] A, int K) {
        int flip = 0, res = 0;
        for(int i = 0; i < A.length; i++){
            if(i >= K && A[i - K] < 0){
                A[i - K] += 2;
                flip--;
            }
            if((flip % 2 == 0 && A[i] == 0) || (flip % 2 == 1 && A[i] == 1)){
                if(i > A.length - K) return -1;
                A[i] = -2;
                flip++;
                res++;
            }
        }
        return res;
    }
}