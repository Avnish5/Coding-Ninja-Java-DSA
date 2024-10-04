package assignment;
/*
Problem statement
Given a string S, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
hello
Sample Output 1:
hel*lo
Sample Input 2 :
aaaa
Sample Output 2 :
a*a*a*a
 */
public class Pair_Star {
    public static String addStars(String s) {

        if(s.length()==1) return s;

        if(s.charAt(0)==s.charAt(1))
        {
            return s.charAt(0)+"*"+addStars(s.substring(1));
        }
        else{
            return s.charAt(0)+addStars(s.substring(1));
        }

    }
}
