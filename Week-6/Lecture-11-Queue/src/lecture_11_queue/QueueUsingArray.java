package lecture_11_queue;

public class QueueUsingArray {

    private int front;
    private int rear;
    private int size;
    private int arr[];

    QueueUsingArray()
    {
        arr=new int[5];
        front=-1;
        rear=-1;
        size=0;
    }

    int size()
    {
        return size;
    }

    boolean isEmpty()
    {
        return size==0;
    }

    int front() throws QueueEmptyException
    {
        if(size==0)
        {
            throw new QueueEmptyException();
        }

        return arr[front];
    }

    void enqueue(int ele) throws QueueFullException
    {
        if(size==arr.length)
        {
            doubleCapacity();
        }
        if(size==0)
        {
            front=0;
        }

        size++;
        rear=(rear+1)%arr.length;
        arr[rear]=ele;

    }

    void doubleCapacity()
    {
        int temp[]=arr;
        arr=new int[2*temp.length];

        int index=0;

        for(int i=front;i<temp.length;i++)
        {
            arr[index]=temp[i];
            index++;
        }

        for(int i=0;i<=front-1;i++)
        {
            arr[index]=temp[i];
            index++;
        }

        front=0;
        rear=temp.length-1;
    }

    int dequeue() throws QueueEmptyException {
        if(size==0)
        {
            throw new QueueEmptyException();
        }

        int temp=arr[front];
        front=(front+1)%arr.length;
        size--;

        if(size==0)
        {
            front=-1;
            rear=-1;
        }

        return temp;
    }
}
