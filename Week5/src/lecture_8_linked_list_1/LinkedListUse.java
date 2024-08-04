package lecture_8_linked_list_1;

import java.net.Inet4Address;
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

    public static Node<Integer> takeInput()
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

    public static Node<Integer> optimizedTakeInput()
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

        Node<Integer> head=optimizedTakeInput();


        Insert_Node_At_ith_Pos p=new Insert_Node_At_ith_Pos();
       head= p.insert(head,80,100);
        print(head);



    }
}
