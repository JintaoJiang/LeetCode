class Solution {
public:
    int consecutiveNumbersSum(int N) {
        int res = 0;
        N *= 2;
        for(int i = 1; i <= sqrt(N); i++){
            if(N % i == 0){
                if(i % 2 == 0 && N / i % 2 == 1 || i % 2 == 1) res++;
            }
        }
        return res;
    }
};
