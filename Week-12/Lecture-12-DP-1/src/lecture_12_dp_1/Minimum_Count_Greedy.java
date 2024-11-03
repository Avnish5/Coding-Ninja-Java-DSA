package lecture_12_dp_1;

import java.util.ArrayList;
import java.util.List;

public class Minimum_Count_Greedy {

    public static int minCount(int n)
    {
        List<Integer> squares=new ArrayList<>();

        for(int i=1;i*i<=n;i++)
        {
            squares.add(i*i);
        }
        int count=0;

        while(n>0)
        {
            for(int i=squares.size()-1;i>=0;i--)
            {
                if(squares.get(i)<=n)
                {
                    n-=squares.get(i);
                    count++;
                    break;
                }
            }
        }
        return count;
    }



}
