class Solution {
public:
    string fractionAddition(string e) {
        int i = 0, d = 1, n = 0;
        while(i < e.size()){
            int denom = 0, numer = 0, op = 1;
            if(e[i] == '-'){ op = -1; ++i; }
            else if(e[i] == '+') ++i;
            while(isdigit(e[i])) numer = numer * 10 + (e[i++] - '0');
            ++i;
            while(i < e.size() && isdigit(e[i])) denom = denom * 10 + (e[i++] - '0');
            n = n * denom + op * numer * d;
            d = d * denom;
            int div = gcd(abs(n), abs(d));
            n /= div; d/= div;
        }
        string res = to_string(n) + "/" + to_string(d);
        return res;
    }
    
    int gcd(int n, int d){
        if(n == 0) return d;
        return gcd(d % n, n);
    }
};
