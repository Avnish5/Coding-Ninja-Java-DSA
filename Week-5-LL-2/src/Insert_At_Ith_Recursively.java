public class Insert_At_Ith_Recursively {

    public static Node<Integer> insert(Node<Integer> head,int data,int pos)
    {
        if(head==null) return head;

        if(pos==0)
        {
            Node<Integer> newNode=new Node<Integer>(data);
            newNode.next=head;
            return newNode;
        }

        head.next=insert(head.next,data,pos-1);
        return head;
    }
}
