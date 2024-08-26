package assignment;

import java.util.PriorityQueue;

/*
Problem statement
Given an array 'arr' of random integers and an integer 'k', return the kth largest element in the array.



Note: Try to do this in O(n*log k) time.


Example:
Input:
5
3 2 5 1 4
2
Output:
4
Explanation:
Array in non increasing form is [5,4,3,2,1]. So the 2nd largest is 4.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6
9 4 8 7 11 3
2
Sample Output 1 :
9
Explanation of sample input 1:
arr = [9,4,8,7,11,3]
Array 'arr' in non increasing form is [11,9,8,7,4,3]. So the 2nd largest is 9.
Sample Input 2 :
8
2 6 10 11 13 4 1 20
4
Sample Output 2 :
10
Constraints :
1 <= n <= 10^5
1 <= arr[i] <= 10^5
1 <= k <= n
Time Limit: 1 sec

 */
public class Kth_Largest_Element {

    public static int kthLargest(int n, int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:input)
        {
            if(pq.size()<k)
            {
                pq.add(i);
            }
            else
            {
                if(i>pq.peek())
                {
                    pq.poll();
                    pq.add(i);
                }
            }
        }

        return pq.peek();

    }
}
