import java.util.Scanner;

public class LinkedListUse {

    public static void print(Node<Integer> head)
    {
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
    }

    public  Node<Integer> takeInput()
    {
        Node<Integer> head=null;
        Scanner s=new Scanner(System.in);
        int data=s.nextInt();

        while(data!=-1)
        {
            Node<Integer> newNode=new Node<Integer>(data);

            if(head==null)
            {
                head=newNode;
            }
            else {
                Node<Integer> temp=head;
                while(temp.next!=null)
                {
                    temp=temp.next;
                }

                temp.next=newNode;
            }

            data=s.nextInt();
        }

        return head;

    }

    public Node<Integer> optimizedTakeInput()
    {
        Node<Integer> head=null;
        Node<Integer> tail=null;
        Scanner s=new Scanner(System.in);
        int data=s.nextInt();

        while(data!=-1)
        {
            Node<Integer> newNode=new Node<Integer>(data);

            if(head==null)
            {
                head=newNode;
                tail=newNode;

            }
            else {
                tail.next=newNode;
                tail=newNode;
            }

            data=s.nextInt();
        }

        return head;

    }

    public static void main(String[] args) {

        LinkedListUse listUse = new LinkedListUse(); // Create an instance
        Node<Integer> head = listUse.optimizedTakeInput(); // Call the method on the instance
        Assignment_Delete_Every_N_nodes p=new Assignment_Delete_Every_N_nodes();
        head=p.skipMdeleteN(head,2,3);
        print(head);


     }
}