package adj_list_graph;

import java.util.ArrayList;

public class Detect_Cycle_Undirected_DFS {
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V=adj.size();
        boolean[] visited=new boolean[V];

        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,visited,adj,-1)) return true;
            }
        }

        return false;

    }

    public boolean dfs(int start,boolean[] visited,ArrayList<ArrayList<Integer>> adj,int parent){
        visited[start]=true;

        for(Integer neighbour:adj.get(start))
        {
            if(!visited[neighbour])
            {
                if(dfs(neighbour,visited,adj,start))
                {
                    return true;
                }
            }else if(parent!=neighbour)
            {
                return true;
            }
        }

        return false;
    }
}
