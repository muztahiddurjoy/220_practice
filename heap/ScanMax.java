package heap;

import java.util.Arrays;

public class ScanMax {
    public static void main(String[] args) {
        int[] numbers = {1,3,-1,-3,5,3,6};
        int k = 3;
        System.out.println(Arrays.toString(ScanMax.scanMaxInGroup(numbers, k)));
    }

    public static int[] scanMaxInGroup(int[] numbers, int k){
        int[] result = new int[numbers.length-k+1];
        int index = 0;
        for(int i=0;i<=numbers.length-k;i++){
                MaxHeap mh = new MaxHeap(k);
                for (int l = i; l < (i+k); l++) {
                    mh.insert(numbers[l]);
                }
                int max = mh.extract();
                result[index++] = max;
            }
        return result;
    }
}
