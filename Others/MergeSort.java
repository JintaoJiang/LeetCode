public class MergeSort {
    public int[] mergeSort(int[] A, int n) {
        sort(A, 0, n - 1);
        return A;
    }
    
    private void sort(int[] A, int lo, int hi){
        if(lo >= hi) return;
        int mid = (lo + hi) / 2;
        sort(A, lo, mid);
        sort(A, mid + 1, hi);        
        int[] res = new int[hi - lo + 1];
        int i = lo, j = mid + 1, p = 0;
        while(i <= mid && j <= hi){
            if(A[i] < A[j]) res[p++] = A[i++];
            else res[p++] = A[j++];
        }
        while(i <= mid) res[p++] = A[i++];
        while(j <= hi) res[p++] = A[j++];
        for(int k = lo; k <= hi; k++) A[k] = res[k - lo];
    }
}