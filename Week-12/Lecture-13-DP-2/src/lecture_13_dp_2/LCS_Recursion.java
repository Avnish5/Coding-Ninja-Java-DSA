package lecture_13_dp_2;
/*
Problem statement
Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.

For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.

Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
adebc
dcadb
Sample Output 1 :
3
Explanation of the Sample Output 1 :
Both the strings contain a common subsequence 'adb', which is the longest common subsequence with length 3.
Sample Input 2 :
ab
defg
Sample Output 2 :
0
Explanation of the Sample Output 2 :
The only subsequence that is common to both the given strings is an empty string("") of length 0.
 */
public class LCS_Recursion {

    public static int lcs(String s, String t) {
        return lcs(s,t,0,0);
    }

    public static int lcs(String s, String t,int i,int j){
        if(i>=s.length() || j>=t.length()) return 0;

        if(s.charAt(i)==t.charAt(j)){
            return 1+lcs(s,t,i+1,j+1);
        }
        else{
            return Math.max(lcs(s,t,i,j+1),lcs(s,t,i+1,j));
        }
    }

}
