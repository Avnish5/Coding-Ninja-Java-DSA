package lecture_12_dp_1;

public class Staricase_Memoization_Recursion {
    public static int staircase(int n) {
        int[] arr = new int[n + 1];


        for (int i = 0; i <= n; i++) {
            arr[i] = -1;
        }

        return  staircase(n, arr);

    }

    public static int staircase(int n, int[] arr) {
        if (n < 0) return 0;
        if (n == 0) return 1;


        if (arr[n] != -1) return arr[n];


        arr[n] = staircase(n - 1, arr) + staircase(n - 2, arr) + staircase(n - 3, arr);
        return arr[n];
    }



}
