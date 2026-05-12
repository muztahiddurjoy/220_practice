package heap;

public class KMax {
    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap(10);
        mh.insert(10);
        mh.insert(5);
        mh.insert(9);
        mh.insert(1);
        mh.insert(2);
        for (int i = 0; i < 3; i++) {
            int val = mh.extract();
            System.out.println(val);
        }

    }
}
