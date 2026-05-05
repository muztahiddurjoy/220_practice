package heap;

public class MaxHeap {
    int[] heap;
    int size;
    int capacity;

    public MaxHeap(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    private int parent(int i){
        return (i-1)/2;
    }
    private int leftChild(int i){
        return (i*2)+1;
    }
    private int rightChild(int i){
        return (i*2)+2;
    }

    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public int getMax(){
        if(size==0){
            System.out.println("Heap is empty");
            return -1;
        }
        return heap[0];
    }

    public void insert(int key){
        if(size==capacity){
            System.out.println("Heap is full!");
            return;
        }
        heap[size] = key;
        int current = size;
        size++;

        while(current>0 && heap[current]>heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMax(){
        if(size==0){
            return -1;
        }
        int max = heap[0];
        heap[0] = heap[--size];
        return max;
    }

    public void maxHeapify(int index){
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if(left < size && heap[left] > heap[largest]){
            largest = left;
        }

        if(right < size && heap[])
    }

}
