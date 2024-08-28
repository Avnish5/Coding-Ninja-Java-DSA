package assignment;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Problem statement
You are given a stream of 'N' integers. For every 'i-th' integer added to the running list of integers, print the resulting median.

Print only the integer part of the median.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6
6 2 1 3 7 5
Sample Output 1 :
6 4 2 2 3 4
Explanation of Sample Output 1 :
S = {6}, median = 6
S = {6, 2} -> {2, 6}, median = 4
S = {6, 2, 1} -> {1, 2, 6}, median = 2
S = {6, 2, 1, 3} -> {1, 2, 3, 6}, median = 2
S = {6, 2, 1, 3, 7} -> {1, 2, 3, 6, 7}, median = 3
S = {6, 2, 1, 3, 7, 5} -> {1, 2, 3, 5, 6, 7}, median = 4
Sample Input 2 :
5
5 4 3 2 1
Sample Output 2 :
5 4 4 3 3

 */
public class RunningMedian {

    public static void findMedian(int arr[])  {

        if(arr.length==0) return;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        maxHeap.add(arr[0]);
        System.out.print(arr[0]+" ");

        for(int i=1;i<arr.length;i++)
        {
            int x=arr[i];

            if(x<=maxHeap.peek())
            {
                maxHeap.add(x);
            }
            else{
                minHeap.add(x);
            }

            if(maxHeap.size()-2==minHeap.size())
            {
                minHeap.add(maxHeap.poll());
            }
            else if(maxHeap.size()==minHeap.size()-2)
            {
                maxHeap.add(minHeap.poll());
            }

            if(maxHeap.size()==minHeap.size())
            {
                System.out.print((maxHeap.peek()+minHeap.peek())/2+" ");
            }
            else if(maxHeap.size()>minHeap.size())
            {
                System.out.print(maxHeap.peek()+" ");
            }
            else
            { System.out.print(minHeap.peek()+" ");

            }
        }

    }
}
