package assignment;

import java.util.HashMap;

/*
Problem statement
You are given with an array of integers and an integer K. You have to find and print the count of all such pairs which have difference K.

Note: Take absolute difference between the elements of the array.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= n <= 10^4
Time Limit: 1 sec
Sample Input 1 :
4
5 1 2 4
3
Sample Output 1 :
2
Explanation
(5,2) and (1,4) are the possible combinations as their absolute difference is 3.
Sample Input 2 :
4
4 4 4 4
0
Sample Output 2 :
6
 */
public class Pairs_With_Diff_K {

    public static void getPairsWithDifferenceK(int arr[], int k){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int num:arr)
        {
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        System.out.println(hm);
        int count=0;

        for(int i=0;i<arr.length;i++){
            int n=Math.abs(arr[i]-k);
            if(hm.containsKey(n))
            {
                count++;
                int freq=hm.get(n);
                if(freq>0) hm.put(n,freq-1);
            }
        }

        System.out.println(count);

    }

    public static void main(String[] args) {
       // int[] arr={4,4,4,4};
        int[] arr={5,1,2,4};
        getPairsWithDifferenceK(arr,3);

    }
}
