package bonus_assignment;
/*
Problem statement
Given a graph with N vertices (numbered from 0 to N-1) and M undirected edges, then count the distinct 3-cycles in the graph. A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are connected by an edge.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 100
0 <= M <= (N*(N-1))/2
0 <= u <= N - 1
0 <= v <= N - 1
Time Limit: 1 sec
Sample Input 1:
3 3
0 1
1 2
2 0
Sample Output 1:
1
 */
public class Three_Cycle {

    public static int solve(boolean[][] graph, int n) {
        int count=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(graph[i][j]==true)
                {
                    for(int k=0;k<n;k++)
                    {
                        if(k!=i&&graph[k][j]==true&&graph[k][i]==true)
                        {
                            count++;
                        }
                    }
                }
            }
        }

        return count/6;
    }
}
