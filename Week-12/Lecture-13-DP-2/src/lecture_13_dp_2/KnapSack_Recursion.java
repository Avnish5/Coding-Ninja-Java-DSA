package lecture_13_dp_2;

public class KnapSack_Recursion {
    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
        return knapsack(weights,values,n,maxWeight,0);
    }

    public static int knapsack(int[] weights, int[] values, int n, int maxWeight,int i){
        if(i>=weights.length) return 0;
        if(maxWeight<weights[i]) return knapsack(weights,values, n,maxWeight,i+1);

        int op1=values[i]+knapsack(weights,values, n,maxWeight-weights[i],i+1);
        int op2=knapsack(weights,values, n,maxWeight,i+1);

        return Math.max(op1,op2);
    }
}
