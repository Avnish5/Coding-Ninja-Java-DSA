package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Merge_K_Sorted_Arrays {

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for (List<Integer> temp : input) {

            for (int value : temp) {
                pq.add(value);
            }
        }

        ArrayList<Integer> result=new ArrayList<>();
        while(!pq.isEmpty())
        {
            result.add(pq.poll());
        }

        return result;

    }
}
