package lecture_12_dp_1;

public class Staircase_Iterative_DP {

    public static long staircase(int n) {
        if(n==0) return 1;
        if(n<0) return 0;

        long[] arr = new long[n + 1];


        arr[0] = 1;
        arr[1] = 1;


        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1];
            if (i - 2 >= 0) arr[i] += arr[i - 2];
            if (i - 3 >= 0) arr[i] += arr[i - 3];
        }

        return arr[n];
    }
}
