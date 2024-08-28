import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void median(int[] input)
    {
        ArrayList<Integer> result=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i:input)
        {
            pq.add(i);
            ArrayList<Integer> temp=new ArrayList<>();

            while(!pq.isEmpty())
            {
                temp.add(pq.poll());
            }

            pq.addAll(temp);

            if(temp.size()%2==0)
            {
                int mid=temp.size()/2;
                result.add((temp.get(mid)+temp.get(mid-1))/2);
            }
            else {
                int mid=temp.size()/2;
                result.add(temp.get(mid));
            }
        }

        for(int i:result)
        {
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        int[] input = {5,4,3,2,1};
        median(input);

    }
}