package assignment;

import java.util.ArrayList;
import java.util.List;

public class Return_Subset_Array_Array_List {

    public static List<List<Integer>> subsets(int input[])
    {
        List<List<Integer>> result=new ArrayList<>();
        result.add(new ArrayList<>());

        for(int num:input)
        {
            int currentSize= result.size();
            for(int i=0;i<currentSize;i++)
            {
                List<Integer> newSubset=new ArrayList<>(result.get(i));
                newSubset.add(num);
                result.add(newSubset);

            }
        }

        return result;
    }

}
