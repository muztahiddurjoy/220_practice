package farsiar_code.matrix;

public class CompressedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {1,3,5,2},
            {-2,0,6,-3}
        };

        int[][] compressed = compress_matrix(matrix);
        System.out.println("Compressed matrix:");
        printArray(compressed);
        
    }

    public static int[][] compress_matrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        if(row%2!=0 || col%2!=0){
            System.out.println("Matrix col and row must be even for compression");
            return new int[0][0];
        }
        int[][] compressed = new int[row/2][col/2];
        for (int i = 0; i < row; i+=2) {
            for (int j = 0; j < col; j+=2) {
                int newValue = matrix[i][j]+matrix[i][j+1]+matrix[i+1][j]+matrix[i+1][j+1];
                compressed[i / 2][j / 2] = newValue;
            }
        }
        return compressed;
    }

    public static void printArray(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
