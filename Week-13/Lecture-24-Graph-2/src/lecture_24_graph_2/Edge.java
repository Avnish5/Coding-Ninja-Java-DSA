package lecture_24_graph_2;

public class   Edge implements Comparable<Edge> {

    int src;
    int des;
    int weight;

    public Edge(int src, int des, int weight) {
        this.src = src;
        this.des = des;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    }
}
