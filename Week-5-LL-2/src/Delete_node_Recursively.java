public class Delete_node_Recursively {
    public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) {
        //Your code goes here
        if(head==null) return null;

        if(pos==0) return head.next;

        head.next=deleteNodeRec(head.next, pos-1);
        return head;
    }
}
