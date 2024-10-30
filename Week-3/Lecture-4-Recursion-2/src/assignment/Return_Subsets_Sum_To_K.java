package assignment;

import java.util.ArrayList;
import java.util.List;

public class Return_Subsets_Sum_To_K {

    public static void returnSubset(int[] arr,int k)
    {
        List<List<Integer>> subSets=new ArrayList<>();
        subSets.add(new ArrayList<>());
        for(int num:arr)
        {
            int currSize=subSets.size();
            for(int i=0;i<currSize;i++)
            {
                List<Integer> newSubset=new ArrayList<>(subSets.get(i));
                newSubset.add(num);
                subSets.add(newSubset);
            }
        }
        List<List<Integer>> result=new ArrayList<>();

        for(List<Integer> list:subSets)
        {
            int sum=list.stream().mapToInt(Integer::intValue).sum();
            if(sum==k)
            {
                result.add(list);
            }
        }

        int[][] output=new int[result.size()][];

        for(int i=0;i<result.size();i++)
        {
            List<Integer> subset=result.get(i);
            output[i] = new int[subset.size()]; // Initialize the inner array
            for (int j = 0; j < subset.size(); j++) {
                output[i][j] = subset.get(j); // Populate the inner array
            }
        }

        for (int[] arrOutput : output) {
        for (int num : arrOutput) {
            System.out.print(num + " ");
        }
        System.out.println(); // New line for each subset
    }


    }

    public static void main(String[] args) {
        int[] input={1,2,3,4,5};
        returnSubset(input,5);
    }
}


