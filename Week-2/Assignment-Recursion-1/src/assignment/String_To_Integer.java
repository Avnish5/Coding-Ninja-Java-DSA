package assignment;
/*
Problem statement
Write a recursive function to convert a given string into the number it represents. That is input will be a numeric string that contains only numbers, you need to convert the string into corresponding integer and return the answer.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 < |S| <= 9
where |S| represents length of string S.
Sample Input 1 :
00001231
Sample Output 1 :
1231
Sample Input 2 :
12567
Sample Output 2 :
12567
 */
public class String_To_Integer {

    public static int convertStringToInt(String input){

        if(input.length()==1)
        {
            return input.charAt(0)-'0';
        }

        return (input.charAt(0)-'0')*(int)Math.pow(10, input.length()-1)+convertStringToInt(input.substring(1));

    }
}
