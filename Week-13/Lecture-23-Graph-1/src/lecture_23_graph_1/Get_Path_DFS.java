package lecture_23_graph_1;

import java.util.ArrayList;

public class Get_Path_DFS {

    public static ArrayList<Integer> getPathDFS(int[][] edges,boolean[] visited,int start,int end)
    {

        if(start==end)
        {
            ArrayList<Integer> ans=new ArrayList<>();
            ans.add(end);
            return  ans;
        }
        visited[start]=true;

        for(int i=0;i<edges.length;i++)
        {
            if(edges[start][i]==1&&!visited[i])
            {
                ArrayList<Integer> ans=getPathDFS(edges,visited,i,end);

                if(ans!=null)
                {
                    ans.add(start);
                    return ans;
                }
            }
        }

        return null;
    }
}
