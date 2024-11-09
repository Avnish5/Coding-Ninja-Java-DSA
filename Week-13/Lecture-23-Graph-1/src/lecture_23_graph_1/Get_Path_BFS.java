package lecture_23_graph_1;

import java.util.*;

public class Get_Path_BFS {

    public static void getPath(int edges[][], int start, int end) {
        int n=edges.length;
        boolean[] visited=new boolean[n];
        boolean flag=false;
        Queue<Integer> q=new LinkedList<>();
        HashMap<Integer,Integer> predecessors=new HashMap<>();

        visited[start]=true;
        predecessors.put(start,null);
        q.add(start);

        while(!q.isEmpty()) {
            int front = q.poll();
            if (front == end) {
                flag = true;
                break;
            }

            for (int i = 0; i < n; i++) {
                if (edges[front][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    predecessors.put(i, front);
                }
            }
        }
        if(!flag) return;

        ArrayList<Integer> path=new ArrayList<>();

        for(Integer at=end;at!=null;at=predecessors.get(at))
        {
            path.add(at);
        }

        for (int node : path) {
            System.out.print(node + " ");
        }
        }

    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int e=s.nextInt();

        int edges[][]=new int[n][n];

        for(int i=0;i<e;i++)
        {
            int fv=s.nextInt();
            int sv=s.nextInt();
            edges[fv][sv]=1;
            edges[sv][fv]=1;
        }

        int start=s.nextInt();
        int end=s.nextInt();
        getPath(edges,start,end);
    }
}
