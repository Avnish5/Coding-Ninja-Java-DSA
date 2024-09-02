import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{

    int source;
    int dest;
    int weight;

    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    }
}
public class lecture_24_graph_2 {

    public static int findParent(int parent[],int v)
    {
        if(parent[v]==v) return v;
        return findParent(parent,parent[v]);
    }
    public static  void  kruskalsAlgo(Edge input[],int n)
    {
        Arrays.sort(input);
        Edge[] output=new Edge[n-1];
        int[] parent=new int[n];

        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }

        int count=0;
        int i=0;

        while(count!=n-1)
        {
            Edge currentEdge=input[i];

            int sourceParent=findParent(parent,currentEdge.source);
            int destParent=findParent(parent,currentEdge.dest);

            if(sourceParent!=destParent)
            {
                output[count]=currentEdge;
                count++;
                parent[sourceParent]=destParent;
            }

            i++;
        }

        for(int j=0;j<n-1;j++)
        {
            if(output[j].source<output[j].dest)
            {
                System.out.println(output[j].source+"  "+output[j].dest+"  "+output[j].weight);
            }
            else {
                System.out.println(output[j].dest+"  "+output[j].source+"  "+output[j].weight);
            }
        }
    }
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int e=s.nextInt();

        Edge[] input=new Edge[e];

        for(int i=0;i<e;i++)
        {
            int source=s.nextInt();
            int dest=s.nextInt();
            int weight=s.nextInt();
            input[i]=new Edge();
            input[i].source=source;
            input[i].dest=dest;
            input[i].weight=weight;

        }

        kruskalsAlgo(input,n);

    }
}
