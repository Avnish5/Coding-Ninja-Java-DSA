package lecture_19_priority_queue_2;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
Problem statement
You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.

Time complexity should be O(nlogk) and space complexity should be not more than O(k).

Order of elements in the output is not important.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input :
13
2 12 9 16 10 5 3 20 25 11 1 8 6
4
Sample Output :
12
16
20
25
 */
public class K_Largest_Element {
    public static ArrayList<Integer> kLargest(int input[], int k) {

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:input)
        {
            if(pq.size()<k)
            {
                pq.add(i);
            }
            else{
                if(pq.peek()<i)
                {
                    pq.poll();
                    pq.add(i);
                }
            }
        }

        ArrayList<Integer> result=new ArrayList<>();

        while(!pq.isEmpty())
        {
            result.add(pq.poll());
        }

        return result;

    }
}
