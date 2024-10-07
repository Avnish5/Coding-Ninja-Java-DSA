import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static String[] getKeypadCharacters(int number) {
        HashMap<Integer, String[]> keypad = new HashMap<>();
        keypad.put(2, new String[]{"a", "b", "c"});
        keypad.put(3, new String[]{"d", "e", "f"});
        keypad.put(4, new String[]{"g", "h", "i"});
        keypad.put(5, new String[]{"j", "k", "l"});
        keypad.put(6, new String[]{"m", "n", "o"});
        keypad.put(7, new String[]{"p", "q", "r", "s"});
        keypad.put(8, new String[]{"t", "u", "v"});
        keypad.put(9, new String[]{"w", "x", "y", "z"});

        // Return the corresponding characters or an empty array for invalid input
        return keypad.getOrDefault(number, new String[]{});
    }

    public static String[] keypad(int n){

        if(n==0)
        {
            String[] output={""};
            return output;
        }

        String[] smallAns=keypad(n/10);
        String[] arr=getKeypadCharacters(n%10);
        String[] ans=new String[smallAns.length* arr.length];
        int k=0;
        for(int i=0;i< arr.length;i++)
        {
            for(int j=0;j< smallAns.length;j++)
            {
                ans[k]=smallAns[j]+arr[i];
                k++;
            }
        }

        return ans;


    }
    public static void main(String[] args) {

        String[] ans=keypad(23);
        for(String s:ans)
        {
            System.out.println(s);
        }
    }
}