package lecture_11_queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queue {
    //Define the data members
    Queue<Integer> q1;
    Queue<Integer>  q2;

    public StackUsing2Queue() {
        //Implement the Constructor
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        //Implement the getSize() function
        return this.q1.size();
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return getSize()==0;
    }

    public void push(int element) {
        //Implement the push(element) function
        q1.add(element);
    }

    public int pop() {
        //Implement the pop() function
        if(q1.isEmpty()) return -1;

        while(this.q1.size()>1)
        {
            this.q2.add(this.q1.poll());
        }

        int ans=this.q1.poll();

        Queue<Integer> temp=this.q1;
        this.q1=this.q2;
        this.q2=temp;

        return ans;
    }

    public int top() {
        //Implement the top() function
        if(q1.isEmpty()) return -1;

        while(this.q1.size()>1)
        {
            this.q2.add(this.q1.poll());
        }

        int ans=this.q1.poll();
        this.q2.add(ans);

        Queue<Integer> temp=this.q1;
        this.q1=this.q2;
        this.q2=temp;

        return ans;

    }
}
