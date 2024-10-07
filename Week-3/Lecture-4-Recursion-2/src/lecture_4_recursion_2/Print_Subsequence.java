package lecture_4_recursion_2;

public class Print_Subsequence {

    public static void printSub(String input,String output)
    {
        if(input.isEmpty())
        {
            System.out.println(output);
            return;
        }

        printSub(input.substring(1),output);
        printSub(input.substring(1),output+input.charAt(0));

    }

    public static  void printSub(String input)
    {
        printSub(input,"");
    }

    public static void main(String[] args) {
        printSub("xyz");
    }
}
