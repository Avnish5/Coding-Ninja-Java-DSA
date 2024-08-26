package assignment;
/*
Problem statement
Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5
1 <= Ai <= 10^5
Time Limit: 1 sec
Sample Input 1:
8
42 20 18 6 14 11 9 4
Sample Output 1:
true
 */
public class Check_Max_Heap {

    public static boolean checkMaxHeap(int arr[]) {

        for(int i=arr.length-1;i>0;i--)
        {
            int parent=(i-1)/2;

            if(arr[i]>arr[parent]) return false;
        }

        return true;
    }
}
