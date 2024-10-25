package lecture_17_hashmap;

import java.util.HashMap;

/*
Problem statement
You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.

Note :
Input arrays/lists can contain duplicate elements.

The intersection elements printed would be in the order they appear in the second array/list (ARR2).


Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 10^6
0 <= M <= 10^6

Time Limit: 1 sec
Sample Input 1 :
6
2 6 8 5 4 3
4
2 3 4 7
Sample Output 1 :
2
3
4
Sample Input 2 :
4
2 6 1 2
5
1 2 3 4 2
Sample Output 2 :
1
2
2
 */
public class Array_Intersection {

    public static void printIntersection(int[] arr1,int[] arr2){

        HashMap<Integer,Integer> hm=new HashMap<>();


        for(int num:arr1)
        {
            hm.put(num,hm.getOrDefault(num,0)+1);
        }


        for(int num:arr2){
            if(hm.containsKey(num))
            {
                int freq=hm.get(num);

                if(freq>0)
                {
                    System.out.println(num);
                }
                hm.put(num,freq-1);

            }
        }



    }

}
