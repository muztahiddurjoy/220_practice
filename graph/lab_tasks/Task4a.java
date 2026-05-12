package graph.lab_tasks;

public class Task4a {
    public static void main(String[] args) {
        int[][] am = new int[4][4];

        am[1][2] = 3;
        am[2][1] = 3;

        am[1][3] = 4;
        am[3][1] = 4;

        am[2][3] = 5;
        am[3][2] = 7;

        for (int i = 0; i < am.length; i++) {
            for (int j = 0; j < am.length; j++) {
                System.out.print(am[i][j]+" ");
            }
            System.out.println();
        }

        makeDirectional(am);
        System.out.println();
        System.out.println();

        for (int i = 0; i < am.length; i++) {
            for (int j = 0; j < am.length; j++) {
                System.out.print(am[i][j]+" ");
            }
            System.out.println();
        }
        
    }

    public static void makeDirectional(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j]==arr[j][i]){
                    arr[j][i] = 0;
                }
                else{
                    arr[i][j] = arr[i][j]+arr[j][i];
                    arr[j][i] = 0;
                }
            }
        }
    }
}
