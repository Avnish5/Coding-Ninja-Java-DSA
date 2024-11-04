package assignment;

import java.util.HashMap;

public class Byte_Landian_Memoization {

    public static long bytelandian(long n, HashMap<Long,Long> memo) {
        if(n==0) return n;
        if(memo.containsKey(n)) return memo.get(n);

        long a=bytelandian(n/2,memo);
        long b=bytelandian(n/3,memo);
        long c=bytelandian(n/4,memo);

        long total=a+b+c;
        long maxValue=Math.max(total, n);
        memo.put(n,maxValue);
        return maxValue;
    }
}
