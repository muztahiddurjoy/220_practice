package temp;

public class While {

    public static void main(String[] args) {
        int i = 0;
        while(i<4) {
            System.out.println(i); //0,1,2,3
            i++;
        }
        i=0;

        do {
            System.out.println(i); //4
            i++;
        } while (false);

    }
}