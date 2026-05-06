package heap;

public class TaskScheduler {
    public static void main(String[] args) {
        int[] tasks = {45,70,85,60,90,75};
        int k = 3;
        cpu_scheduler(tasks, k);
    }

    public static void cpu_scheduler(int[] tasks, int k){
        MaxHeap maxHeap = new MaxHeap(tasks.length);
        for(int task:tasks){
            maxHeap.insert(task);
        }
        for (int i = 0; i < k; i++) {
            System.out.println("Task "+(i+1)+" - Priority "+maxHeap.extract());
        }
    }
}
