package farsiar_code.matrix;

import java.util.Scanner;

public class Seat {

    public static void main(String[] args) {
        String[][] seat = {
            {"A","B","C","D"},
            {"E","F","G","H"},
            {"I","J","K","L"},
            {"M","N","O","P"},
            {"AA","AB","AC","AD"}
        };

        int row = row_rotation(3, seat);
    System.out.println("The new row index of AA after rotation is: " + row);
    }


    public static int row_rotation(int exam_week, String[][] seat_status){
        int newAAindex = -1;

        int row = seat_status.length;
        int col = seat_status[0].length;
        int exam_week_index = exam_week - 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(seat_status[i][j].equals("AA")){
                    newAAindex = i;
                }
            }
        }
        
        if(newAAindex == -1){
            System.out.println("AA does not exist in this array");
            return -1;        }
        int exam_week_row = exam_week_index % row;
        String[][] updated = new String[row][col];
        for (int i = 0; i < row; i++) {
            int new_row = (exam_week_row + i) % row;
            for (int j = 0; j < col; j++) {
                updated[new_row][j] = seat_status[i][j];
            }
        }

        System.out.println("Updated seat status after rotation for exam week " + exam_week + ":");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("|"+updated[i][j]);
            }
            System.out.println("|");
        }
        newAAindex = (newAAindex + exam_week_row) % row;
        return newAAindex;
    }
}