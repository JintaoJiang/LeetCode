class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList();
        generateParenthesis(new char[n * 2], res, 0, 0, n);
        return res;
    }
    
    private void generateParenthesis(char[] s, List<String> res, int i, int j, int n){
        if(i == n && j == n){
            res.add(new String(s));
            return;
        }
        if(i < n){
            s[i + j] = '(';
            generateParenthesis(s, res, i + 1, j, n);
        }            
        if(i > j){
            s[i + j] = ')';
            generateParenthesis(s, res, i, j + 1, n);
        }
    }
}