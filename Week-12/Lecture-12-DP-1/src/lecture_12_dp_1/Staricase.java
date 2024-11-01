package lecture_12_dp_1;
/*
Problem statement
A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count and return all possible ways in which the child can run-up to the stairs.

Detailed explanation ( Input/output format, Notes, Images )
 Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1:
4
Sample Output 1:
7
Sample Input 2:
10
Sample Output 2:
274
 */
public class Staricase {

    public static long staircase(int n) {
        if(n==0) return 1;
        if(n<0) return 0;

        return staircase(n-1)+staircase(n-2)+staircase(n-3);
    }

}
