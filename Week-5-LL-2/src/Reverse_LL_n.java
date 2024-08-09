public class Reverse_LL_n {

    public static DoubleNode reverseLL(Node<Integer> head)
    {
        if(head==null||head.next==null)
        {
            DoubleNode ans=new DoubleNode();
            ans.head=head;
            ans.tail=head;
            return ans;
        }

        DoubleNode smallAns=reverseLL(head.next);
        smallAns.tail.next=head;
        head.next=null;

        DoubleNode ans=new DoubleNode();
        ans.head=smallAns.head;
        ans.tail=head;
        return  ans;


    }
}
