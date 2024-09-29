package lecture_26_backtracking;
/*
Problem statement
You are given a N*N maze with a rat placed at maze[0][0]. Find whether any path exist that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).

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
true
Sample Input 2 :
3
1 0 1
1 0 1
0 1 1
Sample Output 2 :
 false

public class Solution {

	public static boolean isValidPath(int[][] maze,int[][] path,int x,int y,int n)
	{
		return (x>=0 && x<n && y>=0 && y<n && maze[x][y]==1 && path[x][y]!=1);
	}

	public static boolean checkMaze(int[][] maze,int[][] path,int x,int y,int n)
	{


 */
public class Rat_In_A_Maze {
    public static boolean isValidPath(int[][] maze,int[][] path,int x,int y,int n)
    {
        return (x>=0 && x<n && y>=0 && y<n && maze[x][y]==1 && path[x][y]!=1);
    }

    public static boolean checkMaze(int[][] maze,int[][] path,int x,int y,int n)
    {
        if(x==n-1&&y==n-1)
        {
            path[x][y]=1;
            return true;
        }


        if(isValidPath(maze,path,x,y,n))
        {
            path[x][y]=1;

            if(checkMaze(maze,path,x+1,y,n))
            {
                return true;
            }

            if(checkMaze(maze,path,x-1,y,n))
            {
                return true;
            }

            if(checkMaze(maze,path,x,y+1,n))
            {
                return true;
            }

            if(checkMaze(maze,path,x,y-1,n))
            {
                return true;
            }

            path[x][y]=0;
        }

        return false;
    }
    public static boolean ratInAMaze(int maze[][]){
        int n=maze.length;
        int[][] path=new int[n][n];
        return checkMaze(maze,path,0,0,n);
    }
}
