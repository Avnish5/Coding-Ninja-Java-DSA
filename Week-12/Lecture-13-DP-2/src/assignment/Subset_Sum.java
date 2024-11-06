package assignment;

import java.util.ArrayList;

public class Subset_Sum {

    public static boolean subSetSum(int[] arr)
    {
        ArrayList<ArrayList<Integer>> output=subSetSum(arr,0);
        for(ArrayList<Integer> a:output)
        {
            System.out.println(a);
        }
        return false;
    }

    public static ArrayList<ArrayList<Integer>> subSetSum(int[] arr,int i)
    {
        if(i==arr.length)
        {
            ArrayList<ArrayList<Integer>> smallAns=new ArrayList<>();
            smallAns.add(new ArrayList<>());
           return smallAns;
        }
        ArrayList<ArrayList<Integer>> smallAns=subSetSum(arr,i+1);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();

        ans.addAll(smallAns);

        for(ArrayList<Integer> a:smallAns)
        {
            ArrayList<Integer> row = new ArrayList<>(a);
            row.add(arr[i]);
            ans.add(row);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr={1,2};
        subSetSum(arr);
    }
}
