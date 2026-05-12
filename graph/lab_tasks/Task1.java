package graph.lab_tasks;

public class Task1 {
    public static void main(String[] args) {
        int[][] adjM = new int[4][4];
        adjM[0][1] = 1;
        adjM[0][2] = 1;
        adjM[1][0] = 1;
        adjM[1][3] = 1;
        adjM[2][0] = 1;
        adjM[3][1] = 1;
        for (int i = 0; i < adjM.length; i++) {
            for (int j = 0; j < adjM[i].length; j++) {
                System.out.print(adjM[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(findLargestDegree(adjM));
    }

    public static int findLargestDegree(int[][] arr){
        int maxDegree = Integer.MIN_VALUE;
        int maxVertex = -1;
        
        for (int i = 0; i < arr.length; i++) {
            int tempCount = 0;
            for (int j = 0; j < arr.length; j++) {
                tempCount+=arr[i][j];
            }
            if(maxDegree<tempCount){
                maxDegree = tempCount;
                maxVertex = i;
            }
        }
        System.out.println("The vertex with highest number of edges is: "+maxVertex);
        return maxDegree;
    }
}
