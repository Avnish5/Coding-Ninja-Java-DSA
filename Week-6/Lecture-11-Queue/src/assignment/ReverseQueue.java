package assignment;

import java.util.Queue;

public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> input) {
        if (input.isEmpty()) return;
        //Your code goes here
        int t = input.remove();
        reverseQueue(input);
        input.add(t);
    }
}
