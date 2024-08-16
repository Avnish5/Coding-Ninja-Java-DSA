package assignment;

import java.util.Queue;
import java.util.Stack;

public class Reverse_First_K_Element_Using_Stack {
    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {

        if(input.isEmpty()||k>input.size()) return input;
        if(k<=0) return input;

        Stack<Integer> s=new Stack<>();

        for(int i=0;i<k;i++)
        {
            s.push(input.remove());
        }

        while(!s.isEmpty())
        {
            input.add(s.pop());
        }

        for(int i=0;i<input.size()-k;i++)
        {
            input.add(input.remove());
        }

        return input;
    }
}
