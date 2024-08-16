package assignment;

import java.util.LinkedList;
import java.util.Queue;

public class Reverse_First_K_Element {
    public static Queue<Integer> reverseQueue(Queue<Integer> input) {
        if(input.isEmpty()) return input;
        //Your code goes here
        int t=input.remove();
        reverseQueue(input);
        input.add(t);
        return input;
    }

    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
        //Your code goes here
        if(k==0||input.isEmpty()) return input;

        Queue<Integer> q = new LinkedList<>();
        int i=0;

        while(i<k)
        {
            q.add(input.remove());
            i++;
        }

        q=reverseQueue(q);

        while(!input.isEmpty())
        {
            q.add(input.remove());
        }

        return q;

    }
}
