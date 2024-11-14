package bonus_assignment;
/*
Problem statement
An island is a small piece of land surrounded by water . A group of islands is said to be connected if we can reach from any given island to any other island in the same group . Given V islands (numbered from 0 to V-1) and E connections or edges between islands. Can you count the number of connected groups of islands.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V-1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
5 8
0 1
0 4
1 2
2 0
2 4
3 0
3 2
4 3
Sample Output 1:
1


 */
public class Islands {

    public static void numConnectedHelper(int[][] edges,int n,boolean[] visited,int sv)
    {
        visited[sv]=true;
        for(int i=0;i<n;i++)
        {
            if(edges[sv][i]==1 && !visited[i])
            {
                numConnectedHelper(edges,n,visited,i);
            }
        }
    }
    public static int numConnected(int[][] edges, int n) {

        boolean[] visited=new boolean[n];
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                numConnectedHelper(edges,n,visited,i);
                c++;
            }
        }
        return c;
    }
    public static void countFairPairs(int[] nums, int lower, int upper) {

        long ans=0;
        int n=nums.length;

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {

            }
        }

        System.out.println(ans);

    }
    public static void main(String[] args) {
     int[] nums ={1,7,9,2,5};
     int lower=11,upper=11;
     countFairPairs(nums,lower,upper);

    }
}
