class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Double> master = new PriorityQueue();
        PriorityQueue<Double> slave = new PriorityQueue();
        int i = 0, j = 0;
        while(i < nums1.length || j < nums2.length){
            int val = 0;
            if(i == nums1.length){
                val = nums2[j++];
            }else if(j == nums2.length){
                val = nums1[i++];
            }else if(nums1[i] > nums2[j]){
                val = nums2[j++];
            }else{
                val = nums1[i++];
            }
            master.add((double)val);
            if(master.size() > slave.size() + 1){
                slave.add(-master.remove());
            }
        }
        if(master.size() == slave.size()) return (master.peek() - slave.peek()) / 2;
        return master.peek();
    }
}