package lecture_23_graph_1;

public class Has_Path_DFS {

    public static boolean hasPath(int[][] edges,int start,int end,boolean[] visited)
    {
        if(start>=edges.length || end>=edges.length || start<0 || end<0  ) return false;
        if(start==end) return true;
        if(edges[start][end]==1) return true;

        visited[start]=true;

        for(int i=0;i<edges.length;i++)
        {
            if(edges[start][i]==1&&!visited[i])
            {
                if(hasPath(edges, i, end, visited))
                {
                    return true;
                }
            }
        }

        return false;
    }
}
