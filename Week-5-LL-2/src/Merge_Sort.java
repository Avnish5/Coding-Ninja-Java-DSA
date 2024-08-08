public class Merge_Sort {
    public static Node<Integer> mergeTwoSorteds(Node<Integer> head1, Node<Integer> head2) {

        if(head1==null&&head2==null) return null;
        if(head1==null&&head2!=null) return head2;
        if(head2==null&&head1!=null) return head1;

        Node<Integer> h=null,tail=null;

        if(head1.data>head2.data)
        {
            h=head2;
            tail=head2;
            head2=head2.next;
        }
        else{
            h=head1;
            tail=head1;
            head1=head1.next;
        }

        while(head1!=null&&head2!=null)
        {
            if(head1.data>head2.data)
            {
                tail.next=head2;
                tail=head2;
                head2=head2.next;
            }
            else{
                tail.next=head1;
                tail=head1;
                head1=head1.next;
            }
        }

        if(head1==null)
        {
            tail.next=head2;

        }
        else{
            tail.next=head1;
        }

        return h;
    }

    public static Node<Integer> findMiddle(Node<Integer> head)
    {
        if(head==null||head.next==null) return head;
        Node<Integer>  f=head;
        Node<Integer> s=head;

        while(f.next!=null&&f.next.next!=null)
        {
            s=s.next;
            f=f.next.next;
        }

        return s;

    }

    public static Node<Integer> mergeSort(Node<Integer> head) {
        //Your code goes here
        if(head==null||head.next==null) return head;

        Node<Integer> m=findMiddle(head);
        Node<Integer>  rightSide=m.next;
        m.next=null;

        Node<Integer> l=mergeSort(head);
        Node<Integer> r=mergeSort(rightSide);
        Node<Integer>  ans= mergeTwoSorteds(l,r);

        return ans;


    }
}
