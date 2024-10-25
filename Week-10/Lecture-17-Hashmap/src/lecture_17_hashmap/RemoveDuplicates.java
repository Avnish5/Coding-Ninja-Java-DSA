package lecture_17_hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {

    public static  ArrayList<Integer> removeDuplicates(int[] arr)
    {
        HashMap<Integer,Boolean> seen=new HashMap<>();
        ArrayList<Integer> output=new ArrayList<>();

        for(int val:arr)
        {
            if(seen.containsKey(val)) continue;
            output.add(val);
            seen.put(val,true);
        }

       return output;
    }

    public static void main(String[] args) {
        int[] arr={1,2,2,3,4,5,5,1};
        ArrayList<Integer> list=removeDuplicates(arr);
        System.out.println(list);
    }
}
