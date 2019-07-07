class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int[] mod = new int[K];
        int sum = 0, res = 0;
        mod[0] = 1;
        for(int a : A){
            sum = (sum + a) % K;
            if(sum < 0) sum += K;
            res += mod[sum];
            mod[sum]++;
        }
        return res;
    }
}