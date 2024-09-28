package lecture_23_graph_1;

import java.util.LinkedList;
import java.util.Queue;

public class Has_Path_BFS {

    public static boolean hasPath(int[][] edges,int start,int end,boolean[] visited)
    {
        if(start>=edges.length || end>=edges.length || start<0 || end<0  ) return false;

        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visited[start]=true;

        while(!q.isEmpty())
        {
            int front=q.poll();

            for(int i=0;i<edges.length;i++)
            {
                if(edges[front][i]==1&&!visited[i])
                {
                    if(i==end)
                    {
                        return true;
                    }
                    else{
                        q.add(i);
                        visited[i]=true;
                    }
                }
            }
        }

        return false;
    }
}
