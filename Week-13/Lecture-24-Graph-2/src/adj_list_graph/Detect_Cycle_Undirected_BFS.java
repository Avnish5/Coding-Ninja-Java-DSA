package adj_list_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Detect_Cycle_Undirected_BFS {
    private class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V=adj.size();
        boolean[] visited=new boolean[V];

        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,visited,adj)) return true;
            }
        }

        return false;

    }

    public boolean dfs(int start,boolean[] visited,ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q=new LinkedList<>();
        visited[start]=true;
        q.add(new Pair(start,-1));

        while(!q.isEmpty())
        {
            Pair pair=q.poll();
            int node=pair.node;
            int parent=pair.parent;

            for(int neighnour:adj.get(node))
            {
                if(!visited[neighnour])
                {
                    visited[neighnour]=true;
                    q.add(new Pair(neighnour,node));
                }
                else if(neighnour!=parent)
                {
                    return true;
                }
            }
        }

        return false;
    }
}
