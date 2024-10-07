package lecture_4_recursion_2;

import java.util.HashMap;
/*
Problem statement
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.

Return empty string for numbers 0 and 1.

Note :
1. The order of strings are not important.
2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements populated in the output array.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= n <= 10^6

Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf
 */
public class Return_Keypad {
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
}
