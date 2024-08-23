package lecture_17_hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {

    public ArrayList<Integer> removeDuplicate(int[] arr)
    {
        ArrayList<Integer> output=new ArrayList<>();
        HashMap<Integer,Boolean> seen=new HashMap<>();

        for (int i : arr) {
            if (seen.containsKey(i)) {
                continue;
            }

            output.add(i);
            seen.put(i, true);
        }

        return output;
    }
}
