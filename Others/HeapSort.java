public class HeapSort {
    public int[] heapSort(int[] A, int n) {
        for(int i = n / 2 - 1; i >= 0; i--){
            bubbleDown(A, i, n);
        }
        for(int i = 0; i < n - 1; i++){
            swap(A, 0, n - i - 1);
            bubbleDown(A, 0, n - i - 1);
        }
        return A;
    }
    
    private void bubbleDown(int[] A, int i, int len){
        int left = (i + 1) * 2 - 1, right = (i + 1) * 2, child = i;
        if(left < len && A[left] > A[child]) child = left;
        if(right < len && A[right] > A[child]) child = right;
        if(child != i){
            swap(A, i, child);
            bubbleDown(A, child, len);
        }
    }
    
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}