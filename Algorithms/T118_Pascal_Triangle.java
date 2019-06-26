class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList();
        for(int i = 0; i < numRows; i++){
            List<Integer> cur = new LinkedList();
            res.add(cur);
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) cur.add(1);
                else cur.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
        }
        return res;
    }
}