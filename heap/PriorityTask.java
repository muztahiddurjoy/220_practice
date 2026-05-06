package heap;

public class PriorityTask {
    public static void main(String[] args) {
        int[] tasks = {60,85,70,45};
        MaxHeap mh = new MaxHeap(tasks.length);
        for(int task:tasks){
            mh.insert(task);
        }
        for (int i = 0; i < tasks.length; i++) {

            System.out.println("Step "+(i+1)+" - Task "+mh.getIndex(mh));
        }
    }

    
}
