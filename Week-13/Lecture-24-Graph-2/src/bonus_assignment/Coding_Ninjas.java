package bonus_assignment;
/*
Problem statement
Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .

There is a path from any cell to all its neighbouring cells. For a particular cell, neighbouring cells are those cells that share an edge or a corner with the cell.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 1000
1 <= M <= 1000
Time Limit: 1 second
Sample Input 1:
2 11
CXDXNXNXNXA
XOXIXGXIXJX
Sample Output 1:
1
Sample Input 2:
5 5
DANDO
NNINJ
AXGJC
INJAA
CODDI
Sample Output 2:
0
 */
public class Coding_Ninjas {
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
     private static boolean isBound(int x,int y,int n,int m)
     {
         return x>=0&&x<n&&y>=0&&y<m;
     }
    private static boolean dfs(String[] graph, int n, int m, int x, int y, boolean[][] visited, String word, int index) {
        if(index==word.length()) return true;

        visited[x][y]=true;

        for(int i=0;i<8;i++)
        {
            int nx=x+dx[i];
            int ny=y+dy[i];

            boolean isBounded=isBound(nx,ny,n,m);

            if(isBounded&&!visited[nx][ny]&&graph[nx].charAt(ny)==word.charAt(index))
            {
                if(dfs(graph,n,m,nx,ny,visited,word,index+1)) return true;
            }
        }

        visited[x][y]=false;
        return false;
    }

    private static int hasPath(String[] graph, int n, int m) {
        String word = "CODINGNINJA";
        boolean[][] visited=new boolean[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(graph[i].charAt(j)==word.charAt(0))
                {
                    if(dfs(graph,n,m,i,j,visited,word,1))
                    {
                        return 1;
                    }
                }
            }
        }
      return 0;
    }


    public static int solve(String[] Graph , int N, int M){
        return hasPath(Graph,N,M);
    }

    public static void main(String[] args) {
        // Sample input grid
        String[] graph = {
                "CXDXNXNXNXA",
                "XOXIXGXIXJX"
        };


        int N = graph.length;
        int M = graph[0].length();

        // Call solve function with the given input
        int result = solve(graph, N, M);

        if (result == 1) {
            System.out.println("Yes, there is a path that spells 'CODINGNINJA'.");
        } else {
            System.out.println("No, there is no path that spells 'CODINGNINJA'.");
        }
    }


}
