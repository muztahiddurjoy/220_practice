package temp;

import java.util.Scanner;

public class For {
    public static void main(String[] args) { 
        //O(constant) = O(1)
        //O(n) = O(linear)
        System.out.println("FARSIA");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) { //O(n)
            System.out.println("FARSIA");
        }
        //O(n*n*n) = O(n^3)

        for (int i = 0; i < n; i++) {  // 10x20x30 = 6000
            for (int j = 0; j < n; j++) {
                for (int j2 = 0; j2 < n; j2++) {
                    System.out.println("FARSIA");
                }
            }
        }
    }
}
