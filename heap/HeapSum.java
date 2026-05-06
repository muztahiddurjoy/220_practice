package heap;

public class HeapSum {
    public static void main(String[] args) {
        int[] A = {3,2,1,5,4};
        int k = 2;
        System.out.println(heapSum(A, k));
    }    

    public static int heapSum(int arr[], int k){
        int sum = 0;
        if(arr.length==0 || k==0){
            return sum;
        }
        MinHeap minH = new MinHeap(arr.length);
        MaxHeap maxH = new MaxHeap(arr.length);
        for(int elem:arr){
            minH.insert(elem);
            maxH.insert(elem);
        }
        for (int i = 0; i < k; i++) {
            int min = minH.extract();
            int max = maxH.extract();
            int minIndex = getIndex(arr, min);
            int maxIndex = getIndex(arr, max);

            
        }
    
        return sum;
    }
    public static int getIndex(int[] arr,int elem){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==elem){
                return i;
            }
        }
        return -1;
    }
}
