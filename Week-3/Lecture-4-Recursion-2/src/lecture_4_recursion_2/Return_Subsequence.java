package lecture_4_recursion_2;

public class Return_Subsequence {

    public static  String[] returnSubsequence(String input)
    {
        if(input.isEmpty())
        {
            String[] ans={" "};
            return ans;
        }

        String[] smallAns=returnSubsequence(input.substring(1));
        String[] ans=new String[2*smallAns.length];
        int k=0;

        for (String s : smallAns) {
            ans[k] = s;
            k++;
        }

        for (String s : smallAns) {
            ans[k] = input.charAt(0) + s;
            k++;
        }

        return ans;
    }

}
