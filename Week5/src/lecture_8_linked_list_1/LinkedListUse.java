package lecture_8_linked_list_1;

import assignment.Append_Last_n;
import assignment.Eliminate_Duplicates;
import assignment.Palindrome;

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
    public static Node<Integer> reverse(Node<Integer> head)
    {
        Node<Integer> prev=null,nexte=null;

        while(head!=null)
        {
            nexte=head.next;
            head.next=prev;
            prev=head;
            head=nexte;

        }

        return prev;

    }
    public static void main(String[] args) {

        Node<Integer> head=optimizedTakeInput();
        print(head);
        System.out.println();

        Append_Last_n p=new Append_Last_n();
       head= p.appendLastNToFirst(head,3);
       print(head);








    }
}
