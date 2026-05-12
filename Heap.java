public class Heap {

    // Helper class for MinHeap logic
    public static class MinHeap {
        private Integer[] heap;
        private int capacity;
        private int size;

        public MinHeap(int cap) {
            this.capacity = cap;
            this.size = 0;
            // Using cap + 1 because we use 1-based indexing
            this.heap = new Integer[cap + 1];
        }

        public int peek() {
            if (isEmpty()){
                System.out.println("Heap is empty");
                return -1; // Or some other default value
            }
            return heap[1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void insert(int value) {
            if (size >= capacity) {
                System.out.println("Heap is full");
                return;
            }
            size++;
            heap[size] = value;
            swim(size);
        }

        private void swim(int idx) {
            int curr = idx;
            while (curr > 1) {
                int p = curr / 2;
                if (heap[p] > heap[curr]) {
                    swap(curr, p);
                    curr = p;
                } else {
                    break;
                }
            }
        }

        public int extractMin() {
            if (isEmpty()) {
                System.out.println("Heap is empty");
                return -1; // Or some other default value
            }
            int min = heap[1];
            
            // Move the last element to the root
            heap[1] = heap[size];
            size--;
            
            if (size > 1) {
                sink(1);
            }
            return min;
        }

        private int getParent(int index) {
            return index / 2;
        }

        private int getLeftChild(int index) {
            return 2 * index+1;
        }
        private int getRightChild(int index) {
            return 2 * index + 2;
        }

        private void sink(int idx) {
            int curr = idx;
            while (true) {
                int left = getLeftChild(curr);
                int right = getRightChild(curr);
                int smaller = curr;

                if(left <= size && heap[left] < heap[smaller]) {
                    smaller = left;
                }
                
                if(right <= size && heap[right] < heap[smaller]) {
                    smaller = right;
                }
                // If current is already smaller than its smallest child, we are done
                if (smaller==curr) {
                    break;
                }

                swap(curr, smaller);
                curr = smaller;
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    // MaxHeap implementation follows similar logic with reversed comparisons
    public static class MaxHeap {
        private Integer[] heap;
        private int capacity;
        private int size;

        public MaxHeap(int cap) {
            this.capacity = cap;
            this.size = 0;
            this.heap = new Integer[cap + 1];
        }

        public void insert(int value) {
            if (size >= capacity) return;
            heap[++size] = value;
            swim(size);
        }

        private void swim(int idx) {
            while (idx > 1 && heap[idx / 2] < heap[idx]) {
                swap(idx, idx / 2);
                idx = idx / 2;
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
    }
}