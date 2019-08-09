public class QuickSort {
    public int[] quickSort(int[] A, int n) {
        sort(A, 0, n - 1);
        return A;
    }
    
    public void sort(int[] A, int lo, int hi) {
        if(lo >= hi) return;
        int i = lo, j = lo;
        int p = A[i];
        swap(A, i, hi);
        while(j < hi){
            if(A[j] < p) swap(A, i++, j);
            j++;
        }
        swap(A, i, hi);
        sort(A, lo, i - 1);
        sort(A, i + 1, hi);
    }
    
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}