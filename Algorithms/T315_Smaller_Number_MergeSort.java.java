class Solution {
    int[] res;
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        res = new int[n];
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        mergesort(arr);
        List<Integer> list = new LinkedList();
        for(int i : res) list.add(i);
        return list;
    }
    
    private int[][] mergesort(int[][] nums){
        int n = nums.length;
        if(n <= 1) return nums;
        int[][] left = mergesort(Arrays.copyOfRange(nums, 0, n / 2));
        int[][] right = mergesort(Arrays.copyOfRange(nums, n / 2, n));
        int[][] ans = new int[n][2];
        int l1 = 0, l2 = 0;
        for(int i = 0; i < ans.length; i++){
            if(l2 == right.length || (l1 < left.length && left[l1][0] <= right[l2][0])){
                ans[i][0] = left[l1][0];
                ans[i][1] = left[l1][1];
                res[left[l1][1]] += l2;
                l1++;              
            }else{
                ans[i][0] = right[l2][0];
                ans[i][1] = right[l2][1];
                l2++;
            }
        }
        return ans;
    }
}
