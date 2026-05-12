package heap.final_questions;

import heap.MaxHeap;

public class UrgencyTask {
    public static void main(String[] args) {
        urgent_task(new int[]{30, 95, 80, 25, 50}, 3);
    }

    public static void urgent_task(int[] tasks, int deadline){
        MaxHeap mh = new MaxHeap(tasks.length);
        for (int i : tasks) {
            mh.insert(i);
        }
        
        for (int i = 0; i < deadline; i++) {
            if(deadline-i>tasks.length){
                System.out.println("Day "+i+" - No task");
                continue;
            }
            System.out.println("Day "+i+" -  Urgency "+mh.extract());
        }
        System.out.println("Total completed tasks: "+deadline);
        System.out.println("Task ignored: "+(tasks.length-deadline));
    }
}
