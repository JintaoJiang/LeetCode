class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList();
        for(int i : nums) list.add((double)i);
        return DFS(list);
    }
    
    private boolean DFS(List<Double> nums){
        if(nums.size() == 1){
            return Math.abs(nums.get(0) - 24) < 0.001;
        }
        for(int i = 0; i < nums.size(); i++){
            for(int j = i + 1; j < nums.size(); j++){
                double a = nums.get(i), b = nums.get(j);
                for(double ans : Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a)){
                    List<Double> next = new ArrayList();
                    next.add(ans);
                    for(int k = 0; k < nums.size(); k++){
                        if(k != i && k != j) next.add(nums.get(k));
                    }
                    if(DFS(next)) return true;
                }
            }               
        }
        return false;
    }
}