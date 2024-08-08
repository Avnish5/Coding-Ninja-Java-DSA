package lecture_8_linked_list_1;

public class Insert_Node_At_ith_Pos {

    public static Node<Integer> insert(Node<Integer> head,int data,int pos)
    {
        Node<Integer> newNode=new Node<Integer>(data);
        if(pos==0)
        {
            newNode.next=head;
            return newNode;
        }

        int i=0;
        Node<Integer> temp=head;
        while(i<pos-1)
        {
            i++;
            temp=temp.next;
        }



        newNode.next=temp.next;
        temp.next=newNode;
        return head;
    }
}
