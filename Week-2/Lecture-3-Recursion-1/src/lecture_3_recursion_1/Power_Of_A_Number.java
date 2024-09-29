package lecture_3_recursion_1;
/*
Problem statement
Write a program to find x to the power n (i.e. x^n). Take x and n from the user. You need to return the answer.

Do this recursively.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= x <= 30
0 <= n <= 30
Sample Input 1 :
 3 4
Sample Output 1 :
81
Sample Input 2 :
 2 5
Sample Output 2 :
32
 */
public class Power_Of_A_Number {

    public static int power(int x, int n) {
        if(x==0&&n==0) return 1; // if both x and y is 0
        if(x==0) return 0; //if x==0. For example x=0,n=any + number

        if(n==0) return 1; // it is the base case and also work for if x= any + numbrt and n=0. for example x=4,n=0
        return x*power(x,n-1);


    }
}
