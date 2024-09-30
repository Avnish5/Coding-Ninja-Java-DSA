package lecture_3_recursion_1;

public class Is_Array_Sorted {
    public boolean checkSortedArray(int[] input,int si)
    {
        if(si>=input.length-1) return true;
        if(input[si]>input[si+1]) return false;

        boolean smallAns=checkSortedArray(input,si+1);
        return smallAns;
    }
}
