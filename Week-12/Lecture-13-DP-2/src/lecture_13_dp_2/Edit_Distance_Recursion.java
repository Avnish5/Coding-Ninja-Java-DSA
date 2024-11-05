package lecture_13_dp_2;
/*
Problem statement
You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.

Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. In order to do so, you can perform the following three operations:

1. Delete a character
2. Replace a character with another one
3. Insert a character
Note :
Strings don't contain spaces in between.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
abc
dc
Sample Output 1 :
2
 Explanation to the Sample Input 1 :
 In 2 operations we can make string T to look like string S.
First, insert character 'a' to string T, which makes it "adc".

And secondly, replace the character 'd' of string T with 'b' from the string S. This would make string T as "abc" which is also string S.

Hence, the minimum distance.
Sample Input 2 :
whgtdwhgtdg
aswcfg
Sample Output 2 :
9
 */
public class Edit_Distance_Recursion {
    public static int editDistance(String s1, String s2){
        return editDistance(s1,s2,0,0);
    }

    public static int editDistance(String s1, String s2,int i,int j){
        if(i==s1.length()) return s2.length()-j;

        if(j==s2.length()) return s1.length()-i;
        if(s1.charAt(i)==s2.charAt(j)) return editDistance(s1, s2,i+1,j+1);

        int insert=1+editDistance(s1,s2,i,j+1);
        int delete=1+editDistance(s1,s2,i+1,j);
        int replace=1+editDistance(s1, s2,i+1,j+1);

        return Math.min(insert,Math.min(delete,replace));
    }

}
