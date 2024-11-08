package lecture_23_graph_1;

public class DFS_Traversal {

    public static void printDFSHelper(int[][] edges,boolean[] visited,int sv){
        System.out.println(sv);
        visited[sv]=true;
        int n=edges.length;

        for(int i=0;i<n;i++)
        {
            if(edges[sv][i]==1&&!visited[i])
            {
                printDFSHelper(edges,visited,i);
            }
        }
    }
    public static void printDFS(int[][] edges){
        boolean[] visited=new boolean[edges.length];

        for(int i=0;i< edges.length;i++)
        {
            if(!visited[i])
            {
                printDFSHelper(edges,visited,i);
            }
        }
    }
}
