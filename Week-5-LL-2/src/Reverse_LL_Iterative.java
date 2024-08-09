public class Reverse_LL_Iterative {
    public static Node<Integer> reverse_I(Node<Integer> head){
        if(head==null||head.next==null) return head;

        Node<Integer> prev=null,next=null;

        Node<Integer> curr=head;

        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }
}
