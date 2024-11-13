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
 */
public class Connecting_Dots {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1,};
    private static boolean isBound(int x,int y,int n,int m)
    {
        return x>=0&&x<n&&y>=0&&y<m;
    }
    private static int dfs(String[] graph, int n, int m, int x, int y, boolean[][] visited) {
        boolean isBounded=isBound(x,y,n,m);
        if(!isBounded) return 0;

        visited[x][y]=true;
        int ans=1;
        for(int i=0;i<4;i++)
        {
            int nx=x+dx[i];
            int ny=y+dy[i];

            boolean isBoundeding=isBound(nx,ny,n,m);

            if(isBoundeding&&!visited[nx][ny]&&graph[nx].charAt(ny)=='1')
            {
                ans+=dfs(graph,n,m,nx,ny,visited);

            }
        }


        return ans;
    }

    private static int hasPath(String[] graph, int n, int m) {
        boolean[][] visited=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(graph[i].charAt(j)=='1' &&!visited[i][j])
                {
                    int smallAns=dfs(graph,n,m,i,j,visited);
                    ans=Math.max(smallAns,ans);

                }
            }
        }
        return ans;
    }


    public static int dfs(String[] edge, int n) {
        int N = edge.length;
        int M = edge[0].length();
        return hasPath(edge,N,M);
    }

}
