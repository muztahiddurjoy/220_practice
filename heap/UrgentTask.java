package heap;

public class UrgentTask {
    public static void main(String[] args) {
        int[] tasks = {30,95,80,25,50};
        int deadline = 3;
        urgent_task(tasks, deadline);
    }    

    public static void urgent_task(int[] tasks,int deadline){
        MaxHeap mh= new MaxHeap(tasks.length);
        for(int task:tasks){
            mh.insert(task);
        }
        int completed = 0;
        for (int i = 0; i < deadline; i++) {
            System.out.println("Day "+(i+1)+" - "+"Urgency "+mh.extract());
            completed++;
        }
        System.out.println("\nTask Completed: "+completed);
        System.out.println("Task Ignored: "+(tasks.length-completed));
    }
}
