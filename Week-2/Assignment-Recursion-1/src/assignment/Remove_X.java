package assignment;
/*
Problem statement
Given a string, compute recursively a new string where all 'x' chars have been removed.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= |S| <= 10^3
where |S| represents the length of string S.
Sample Input 1 :
xaxb
Sample Output 1:
ab
Sample Input 2 :
abc
Sample Output 2:
abc
Sample Input 3 :
xx
Sample Output 3:
 */
public class Remove_X {

    public static String removeX(String input){
        // Write your code here
        if(input.length()==1)
        {
            return input.charAt(0)=='x'?" ":input;
        }
        if(input.charAt(0)=='x')
        {
            return removeX(input.substring(1));
        }
        else{
            return input.charAt(0)+removeX(input.substring(1));
        }

    }
}
