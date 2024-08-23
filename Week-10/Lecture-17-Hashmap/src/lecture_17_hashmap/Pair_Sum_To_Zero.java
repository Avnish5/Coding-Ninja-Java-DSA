package lecture_17_hashmap;

import java.util.HashMap;

/*
Problem statement
Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.



Note:
Array A can contain duplicate elements as well.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 10^4
Time Limit: 1 sec
Sample Input 1:
5
2 1 -2 2 3
Sample Output 1:
2
Explanation
(2,-2) , (-2,2) will result in 0 , so the answer for the above problem is 2.
 */
public class Pair_Sum_To_Zero {
    public static int PairSum(int[] arr, int size) {

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:arr)
        {
            map.put(num,map.getOrDefault(num, 0)+1);
        }

        int count=0;

        for(int num:arr)
        {
            if(map.containsKey(-num))
            {
                count += map.get(-num);
            }

            if(num==0) count--;

        }


        return count/2;
    }
}
