package lecture_11_queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing1Queue {
    //Define the data members
    Queue<Integer> q1;


    public StackUsing1Queue() {
        //Implement the Constructor
        q1=new LinkedList<>();

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

        for(int i=0;i<q1.size()-1;i++)
        {
            q1.add(q1.remove());
        }
    }

    public int pop() {
        //Implement the pop() function
        if(q1.isEmpty()) return -1;
        return  q1.remove();

    }

    public int top() {
        //Implement the top() function
        if(q1.isEmpty()) return -1;


        return q1.peek();

    }
}
