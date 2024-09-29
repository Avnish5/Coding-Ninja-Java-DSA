package lecture_26_backtracking;
/*
Problem statement
You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).

Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 < N < 11 0 <= Maze[i][j] <=1

Time Limit: 1sec
Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
1 0 0 1 0 0 1 1 1
Sample Output 1 Explanation :
Only 1 path is possible

1 0 0
1 0 0
1 1 1
Which is printed from left to right and then top to bottom in one line.

Sample Input 2 :
3
1 0 1
1 1 1
1 1 1
Sample Output 2 :
1 0 0 1 1 1 1 1 1
1 0 0 1 0 0 1 1 1
1 0 0 1 1 0 0 1 1
1 0 0 1 1 1 0 0 1
Sample Output 2 Explanation :
4 paths are possible which are printed in the required format.
 */
public class Rat_In_A_Maze_All_Path {
    public static boolean isValidPath(int[][] maze,int[][] path,int x,int y,int n)
    {
        return (x>=0 && x<n && y>=0 && y<n && maze[x][y]==1 && path[x][y]!=1);
    }

    public static void checkMaze(int[][] maze,int[][] path,int x,int y,int n)
    {
        if(x==n-1&&y==n-1)
        {
            path[x][y]=1;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(path[i][j]+" ");

                }
            }

            System.out.println();
            path[x][y]=0;
            return;
        }

        if(isValidPath(maze,path,x,y,n))
        {
            path[x][y]=1;

            checkMaze(maze,path,x+1,y,n);
            checkMaze(maze,path,x-1,y,n);
            checkMaze(maze,path,x,y+1,n);
            checkMaze(maze,path,x,y-1,n);
            path[x][y]=0;
        }
    }
    public static void  ratInAMaze(int maze[][],int n){

        int[][] path=new int[n][n];
        checkMaze(maze,path,0,0,n);
    }
}
