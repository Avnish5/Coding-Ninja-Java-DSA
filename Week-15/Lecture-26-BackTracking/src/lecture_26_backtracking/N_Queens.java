package lecture_26_backtracking;
/*
Problem statement
You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any other queen on the chess board. A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4
Sample Output 1 :
0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0
0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0
 */
public class N_Queens {
    public static boolean check(int[][] matrix,int i,int j)
    {
        for (int k = 0; k < i; k++) {
            if (matrix[k][j] == 1 ||
                    (j - (i - k) >= 0 && matrix[k][j - (i - k)] == 1) ||
                    (j + (i - k) < matrix.length && matrix[k][j + (i - k)] == 1)) {
                return false;
            }
        }
        return true;
    }
    public static void place(int[][] matrix,int r,int n)
    {
        if(r==n)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(matrix[i][j]+" ");
                }


            }
            System.out.println();
            return;
        }

        for(int c=0;c<n;c++)
        {
            if(check(matrix,r,c))
            {
                matrix[r][c]=1;
                place(matrix,r+1,n);
                matrix[r][c]=0;
            }
        }


    }

    public static void placeNQueens(int n){

        int[][] matrix=new int[n][n];
        place(matrix,0,n);
    }
}
