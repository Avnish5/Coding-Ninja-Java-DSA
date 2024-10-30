package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
Problem statement
You are given an array of unique integers that contain numbers in random order. You have to find the longest possible sequence of consecutive numbers using the numbers from given array.

You need to return the output array which contains starting and ending element. If the length of the longest possible sequence is one, then the output array must contain only single element.

Note:
1. Best solution takes O(n) time.
2. If two sequences are of equal length, then return the sequence starting with the number whose occurrence is earlier in the array.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= n <= 10^6
Time Limit: 1 sec
Sample Input 1 :
13
2 12 9 16 10 5 3 20 25 11 1 8 6
Sample Output 1 :
8 12
Explanation:The longest consecutive sequence here is [8, 9, 10, 11, 12]. So the output is the start and end of this sequence: [8, 12].
Sample Input 2 :
7
3 7 2 1 9 8 41
Sample Output 2 :
7 9
Explanation:There are two sequences of equal length here: [1,2,3] and [7,8,9]. But since [7,8,9] appears first in the array (7 comes before 1), we return this sequence. So the output is [7,9].
Sample Input 3 :
7
15 24 23 12 19 11 16
Sample Output 3 :
15 16
Explanation:The longest consecutive sequence here is [15,16]. So the output is [15,16].

 */
public class Longest_Consequitive_Sequence {

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {

        HashMap<Integer,Boolean> hm=new HashMap<>();
        for(int num:arr)
        {
            hm.put(num,true);
        }

        int longestStart=0;
        int longestEnd=0;
        int longestLength=0;

        for(int num:arr)
        {
            if(!hm.containsKey(num-1))
            {
                int currentNum=num;
                int currentLength=1;

                while(hm.containsKey(currentNum+1)){
                    currentNum++;
                    currentLength++;
                }

                if(currentLength>longestLength)
                {
                    longestLength=currentLength;
                    longestStart=num;
                    longestEnd=currentNum;
                }
            }
        }

        ArrayList<Integer> result=new ArrayList<>();
        if(longestLength>1)
        {
            result.add(longestStart);
            result.add(longestEnd);
        }
        else {
            result.add(longestStart);
        }

        return result;
    }

}
