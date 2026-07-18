package farsiar_code.matrix;

public class RotateSecret {

    public static void rotateSecret(char[][] board) {
        int n=board.length;
        int layer=n/2;

        for (int L=0;L<layer;L++) {
            int top = L;
            int left= L;
            int bottom=n-1-L;
            int right=n-1-L;
            int times=layer-L;  
            for (int t=0;t<times;t++) {
                rotateRingOnceClockwise(board,top,left,bottom,right);
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                System.out.print(board[i][j]);
            }
        }
        System.out.println();
    }

    private static void rotateRingOnceClockwise(char[][] b, int top, int left,
                                         int bottom, int right) {
        char temp=b[top][left];
        for(int i=top;i < bottom; i++){
            b[i][left]=b[i + 1][left];
        }
        for(int j=left;j<right; j++){
            b[bottom][j]=b[bottom][j + 1];

        }
        for(int i=bottom;i>top; i--){
            b[i][right]=b[i-1][right];
        }
        for (int j = right; j > left + 1; j--){
            b[top][j]  = b[top][j - 1];
        }
        b[top][left + 1]    = temp;
    }

    public static void main(String[] args) {
        RotateSecret rs = new RotateSecret();

        char[][] board1 = {
            {'T','A','U','S'},
            {'A','R','I','.'},
            {'D','T','T','N'},
            {'S','C','F','U'}
        };

        char[][] board2 = {
            {'O','R','I','R','N','P'},
            {'G','S','A','A','L','R'},
            {'L','M','N','O','N','Y'},
            {'A','H','U','O','O','P'},
            {'T','F','C','T','H','S'},
            {'E','D','Y','O','C','K'}
        };

       rotateSecret(board1);   // expected: DATASTRUCTISFUN.
       rotateSecret(board2);   // expected: ALGORITHMSAREFUNANDCOOLPYTHONROCKSPY
    }
}