package lecture_24_graph_2;

public class Union_Find_Algo_By_Rank {

    int[] parent;
    int[] rank;

    Union_Find_Algo_By_Rank(int size){
        parent=new int[size];
        rank=new int[size];

        for(int i=0;i<size;i++){
            parent[i]=i;
        }
    }

    public int find(int i)
    {
        if(parent[i]!=i)
        {
            parent[i]=find(parent[i]);
        }

        return parent[i];
    }

    public void unionByRank(int i,int j)
    {
        int irep=find(i);
        int jrep=find(j);

        if (irep == jrep)
            return;

        int irank=rank[irep];
        int jrank=rank[jrep];

        if(irank<jrank)
        {
            parent[irep]=jrep;
        }
        else if(jrank<irank)
        {
            parent[jrep]=irep;
        }
        else{
            parent[irep]=jrep;
            rank[jrep]++;
        }
    }
}
