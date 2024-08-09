public class Reverse_LL_n2 {

    public static Node<Integer> reverseLL(Node<Integer> head)
    {
        if(head==null||head.next==null) return head;

        Node<Integer> finalHead=reverseLL(head.next);
        Node<Integer> temp=finalHead;

        while(temp.next!=null)
        {
            temp=temp.next;
        }

        temp.next=head;
        head.next=null;
        return finalHead;

    }
}
