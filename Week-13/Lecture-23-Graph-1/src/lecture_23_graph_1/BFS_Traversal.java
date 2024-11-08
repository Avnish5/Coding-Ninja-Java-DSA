package lecture_23_graph_1;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Traversal {

    public static void printBFSHelper(int[][] edges,boolean[] visited,int sv){

        Queue<Integer> q=new LinkedList<>();
        q.add(sv);
        int n=edges.length;

        while(!q.isEmpty())
        {
            int top=q.poll();
            visited[top]=true;
            System.out.print(top+" ");

            for(int i=0;i<n;i++){
                if(edges[top][i]==1&&!visited[i])
                {
                    q.add(i);
                    visited[i]=true;

                }
            }
        }

    }
    public static void printBFS(int edges[][])
    {
        boolean[] visited=new boolean[edges.length];
        for(int i=0;i<edges.length;i++)
        {
            if(!visited[i])
            {
                printBFSHelper(edges,visited,i);
            }
        }
    }
}
