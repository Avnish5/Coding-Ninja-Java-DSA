package adj_list_graph;

import java.util.ArrayList;

public class Detect_Cycle_directed_DFS {

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited=new boolean[V];
        boolean[] recS=new boolean[V];

        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                if(bfs(i,adj,visited,recS)) return true;
            }
        }
        return false;
    }

    public boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recS){
        visited[start]=true;
        recS[start]=true;

        for(int neighbour:adj.get(start))
        {
            if(!visited[neighbour])
            {
                if(bfs(neighbour,adj,visited,recS)) return true;
            }
            else if(recS[neighbour])
            {
                return true;
            }
        }

        recS[start]=false;
        return false;
    }
}
