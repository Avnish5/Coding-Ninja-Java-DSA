import java.util.HashMap;

public class Main {

    public static int maxFrequencyNumber(int[] arr){
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int num:arr)
        {
            hm.put(num,hm.getOrDefault(num,0)+1);
        }

        int ans=Integer.MIN_VALUE;
        int count=0;

        for(int i:arr)
        {
            if(hm.get(i)>count)
            {
                count=hm.get(i);
                ans=i;
            }
        }

        return ans;
    }

        public static void main(String[] args) {
            int arr[]={7,2,2,4,8,4};
            maxFrequencyNumber(arr);


        }
}