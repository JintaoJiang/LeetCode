class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = null, res = null;
        for(int i = 0; i <= rowIndex; i++){
            last = res;
            res = new LinkedList();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) res.add(1);
                else res.add(last.get(j - 1) + last.get(j));
            }
        }
        return res;
    }
}