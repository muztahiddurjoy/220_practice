package heap;

public class MaxHeap {
    int[] heap;
    int size;
    int capacity;

    public MaxHeap(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.heap = new int[capacity+1];
    }
    
    private int getParentIndex(int i){
        return i/2;
    }

    private int getleftChild(int i){
        return 2*i;
    }
    private int getRightChild(int i){
        return 2*i+1;
    }

    private void swap(int i1, int i2){
        int temp  = heap[i1];
        heap[i1]=heap[i2];
        heap[i2]=temp;
    }
    public void insert(int elem){
        if(size==capacity){
            System.out.println("Cannot add more");
            return;
        }
        heap[++size] = elem;
        heapifyUp();
    }

    public int deleteMax(){
        if(size==0){
            return -1;
        }
        int max = heap[1];
        swap(1, size--);
        heapifyDown();
        return max;
    }

    public int extract(){
        if(size==0){
            System.out.println("no elems");
            return -1;
        }
        int max = heap[1];
        swap(1, size--);
        heapifyDown();
        return max;
    }

    private void heapifyUp(){
        if(size==0){
            return;
        }
        int index = size;
        while(index>1 && heap[index]>heap[getParentIndex(index)]){
            swap(index,getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(){
        if(size==0){
            return;
        }
        int index = 1;
        while(true){
            int leftChildIndex = getleftChild(index);
            int rightChildIndex = getRightChild(index);
            int largestIndex = index;
            if(leftChildIndex<=size && heap[leftChildIndex]>heap[largestIndex]){
                largestIndex = leftChildIndex;
            }
            if(rightChildIndex<=size && heap[rightChildIndex]>heap[largestIndex]){
                largestIndex = rightChildIndex;
            }
            if(index==largestIndex){
                return;
            }
            swap(index, largestIndex);
            index = largestIndex;
        }
    }

}
