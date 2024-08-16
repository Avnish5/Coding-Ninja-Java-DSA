package lecture_11_queue;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public class QueueUsingLinkedList {
    //Define the data members
    private Node head;
    private Node tail;
    int size;


    public QueueUsingLinkedList() {
        //Implement the Constructor
        head=null;
        tail=null;
        size=0;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        //Implement the getSize() function
        return size;
    }


    public boolean isEmpty() {
        //Implement the isEmpty() function
        return size==0;
    }


    public void enqueue(int data) {
        //Implement the enqueue(element) function

        Node newNode=new Node(data);

        if(head==null)
        {
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
        size+=1;
    }


    public int dequeue() {
        //Implement the dequeue() function
        if(head==null)
        {
            return -1;
        }
        else{
            int t=head.data;
            head=head.next;
            size-=1;
            return t;
        }


    }


    public int front() {
        //Implement the front() function
        if(head==null)
        {
            return -1;
        }
        else{
            return head.data;
        }
    }
}
