package heap;

public class MinHeapTester {
    public static void main(String[] args) {
        MinHeap mh = new MinHeap(10);
        mh.insert(0);
        mh.insert(5);
        mh.insert(10);
        mh.insert(15);
        mh.insert(20);
        System.out.println(mh.extractMin());
        System.out.println(mh.extractMin());
        System.out.println(mh.extractMin());
        System.out.println(mh.extractMin());
        System.out.println(mh.extractMin());
    }
}


class MinHeap{
    int[] heap;
    int size;
    int capacity;

    public MinHeap(int capacity){
        this.heap = new int[capacity+1];
        this.capacity = capacity;
        this.size = 0;
    }

    private void swap(int i1, int i2){
        int temp = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = temp;
    }

    private int getParent(int i){
        return i/2;
    }
    private int getLeftChild(int i){
        return 2*i;
    }
    private int getRightChild(int i){
        return 2*i+1;
    }

    public void insert(int elem){
        if(size==capacity){
            System.out.println("Heap is full");
            return;
        }
        heap[++size] = elem;
        heapifyUp();   
    }

    private void heapifyUp(){
        if(size==0){
            return;
        }
        int index = size;
        int parentIndex= getParent(index);
        while(index>1 && heap[index]<heap[parentIndex]){
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParent(index);
        }
    }

    public int extractMin(){
        if(size==0){
            System.out.println("Heap is empty");
            return -1;
        }
        int min = heap[1];
        heap[1] = heap[size--];
        heapifyDown();
        return min;
    }

    private void heapifyDown(){
        int index = 1;
        while(true){
            int leftChildIndex = getLeftChild(index);
            int rightChildIndex = getRightChild(index);
            int smallestIndex = index;

            if(leftChildIndex<=size && heap[leftChildIndex]<heap[smallestIndex]){
                smallestIndex = leftChildIndex;
            }
            if(rightChildIndex<=size && heap[rightChildIndex]<heap[smallestIndex]){
                smallestIndex = rightChildIndex;
            }
            if(index==smallestIndex){
                break;
            }
            swap(index, smallestIndex);
            index = smallestIndex;
        }
    }

    public int getMin(){
        if(size==0){
            System.out.println("Heap is empty");
            return -1;
        }
        return heap[1];
    }
    
    public void deleteMin(){
        if(size==0){
            System.out.println("Heap is empty");
            return;
        }
        heap[1] = heap[size--];
        heapifyDown();
    }

    public void delete(int index){
        if(index<1 || index>size){
            System.out.println("Invalid index");
            return;
        }
        heap[index] = heap[size--];
        heapifyDown();
    }
} 