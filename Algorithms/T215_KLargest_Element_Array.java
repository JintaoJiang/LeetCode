class Solution {
    public static int findKthLargest(int[] nums, int k) {
	        int lo = 0, hi = nums.length - 1, pivot = -1;
	        k = nums.length - k;
	        while(pivot != k){
	            pivot = partition(nums, lo, hi);
	            if(pivot == k) return nums[pivot];
	            if(pivot > k) hi = pivot - 1;
	            else lo = pivot + 1;
	        }
	        return 0;
	    }
	    
	    private static int partition(int[] nums, int lo, int hi){
	        int i = lo, j = hi, pivot = nums[lo];
	        while(i <= j){
	            if(nums[i] >= pivot) swap(nums, i, j--);
	            else i++;
	        }
	        swap(nums, i, hi);
	        return i;
	    }
	    
	    private static void swap(int[] nums, int i, int j){
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
}