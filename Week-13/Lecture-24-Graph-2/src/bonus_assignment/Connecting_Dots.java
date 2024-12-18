package bonus_assignment;
/*
Problem statement
Gary has a board of size NxM. Each cell in the board is a coloured dot. There exist only 26 colours denoted by uppercase Latin characters (i.e. A,B,...,Z). Now Gary is getting bored and wants to play a game. The key of this game is to find a cycle that contain dots of same colour. Formally, we call a sequence of dots d1, d2, ..., dk a cycle if and only if it meets the following condition:

1. These k dots are different: if i ≠ j then di is different from dj.
2. k is at least 4.
3. All dots belong to the same colour.
4. For all 1 ≤ i ≤ k - 1: di and di + 1 are adjacent. Also, dk and d1 should also be adjacent. Cells x and y are called adjacent if they share an edge.
Since Gary is colour blind, he wants your help. Your task is to determine if there exists a cycle on the board.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
2 <= N <= 1000
2 <= M <= 1000
Time Limit: 1 second
Sample Input 1:
3 4
AAAA
ABCA
AAAA
Sample Output 1:
true
import java.util.*;

public class Solution {

    int solve(String[] board , int n, int m)
	{
		return 1;
	}




 */
public class Connecting_Dots {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1,};

    public  static  boolean isBound(int x,int y,int n,int m){
        return x>=0&&x<n&&y>=0&&y<m;
    }
    private static boolean dfs(String[] board, int n, int m, int x, int y,int px,int py, boolean[][] visited,char color,int depth){
        visited[x][y]=true;

        for(int i=0;i<4;i++)
        {
            int nx=x+dx[i];
            int ny=y+dy[i];

            boolean isBounded=isBound(nx,ny,n,m);

            if(isBounded&&board[nx].charAt(ny)==color)
            {
                if(!visited[nx][ny])
                {
                    if(dfs(board,n,m,nx,ny,x,y,visited,color,depth+1)) return true;
                }
                else if(nx!=px||ny!=py)
                {
                    if(depth>=4) return true;
                }
            }
        }

     return false;
    }

    int solve(String[] board , int n, int m){
        boolean[][] visited=new boolean[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!visited[i][j])
                {
                    if(dfs(board,n,m,i,j,-1,-1,visited,board[i].charAt(j),1)) return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] graph = {
                "AAAA",
                "ABCA",
                "AAAA"
        };
        int N = graph.length;
        int M = graph[0].length();
    }

}
