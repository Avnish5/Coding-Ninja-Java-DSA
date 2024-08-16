package lecture_11_queue;

public class QueueUse {
    public static void main(String[] args) throws QueueFullException, QueueEmptyException {

        QueueUsingArray q=new QueueUsingArray();

        for(int i=0;i<7;i++)
        {
            q.enqueue(i+1);
        }

        System.out.println(q.front());

        q.dequeue();
        q.dequeue();
        q.dequeue();

        System.out.println(q.front());

        q.enqueue(90);
        System.out.println(q.front());

    }
}
