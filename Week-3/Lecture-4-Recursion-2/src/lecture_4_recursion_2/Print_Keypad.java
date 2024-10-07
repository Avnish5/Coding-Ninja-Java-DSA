package lecture_4_recursion_2;

import java.util.HashMap;

public class Print_Keypad {

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
    public static void printKeypad(int input,String output)
    {
        if(input==0)
        {
            System.out.println(output);
            return;
        }

        String[] arr=getKeypadCharacters(input%10);
        for(int i=0;i<arr.length;i++)
        {
            printKeypad(input/10,arr[i]+output);
        }
    }
    public static void printKeypad(int input){

        printKeypad(input,"");

    }
}
