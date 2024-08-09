public class Assignment_Even_After_Odd {

    public static Node<Integer> evenAfterOdd(Node<Integer> head) {
        //Your code goes here
        if(head==null||head.next==null) return head;
        Node<Integer> eh=null,et=null,oh=null,ot=null;

        while(head!=null)
        {
            if(head.data%2==0)
            {
                if(eh==null)
                {
                    eh=head;
                    et=head;
                }
                else{
                    et.next=head;
                    et=head;
                }
            }
            else{
                if(oh==null)
                {
                    oh=head;
                    ot=head;
                }
                else{
                    ot.next=head;
                    ot=head;
                }
            }

            head=head.next;
        }

        if(eh==null)
        {
            ot.next=null;
            return oh;
        }
        if(oh==null)
        {
            et.next=null;
            return eh;
        }

        et.next=null;
        ot.next=eh;
        return oh;
    }
}
