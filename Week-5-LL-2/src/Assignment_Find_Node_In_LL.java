public class Assignment_Find_Node_In_LL {
    public static int findNodeRec(Node<Integer> head, int n) {
        if(head==null) return -1;

        if(head.data==n) return 0;

        int res=findNodeRec(head.next, n);

        return res==-1?-1:1+res;
    }
}
