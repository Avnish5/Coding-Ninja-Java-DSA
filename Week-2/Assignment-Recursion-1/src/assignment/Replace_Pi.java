package assignment;
/*
Problem statement
Given a string, compute recursively a new string where all appearances of "pi" have been replaced by "3.14".

Constraints :
1 <= |S| <= 50
where |S| represents the length of string S.
Constraints :
1 <= |S| <= 50
where |S| represents the length of string S.
Sample Input 1 :
xpix
Sample Output :
x3.14x
Sample Input 2 :
pipi
Sample Output :
3.143.14
Sample Input 3 :
pip
Sample Output :
3.14p
Constraints:-
1<=|S|<=50
 */
public class Replace_Pi {

    public static String replace(String input){

        if(input.length()<2) return input;
        String ans=replace(input.substring(1));

        if(input.charAt(0)=='p'&&ans.charAt(0)=='i')
        {
            return 3.14+ans.substring(1);
        }
        else{
            return input.charAt(0)+ans;
        }

    }
}
