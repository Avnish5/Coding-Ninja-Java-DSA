package lecture_13_dp_2;

public class Edit_Distance_Memoization {
    public static int editDistance(String s1, String s2){
        int M=s1.length()+1;
        int N=s2.length()+1;

        int[][] memo=new int[M][N];

        for(int i=0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                memo[i][j]=-1;
            }
        }
        return editDistance(s1,s2,0,0,memo);
    }

    public static int editDistance(String s1, String s2,int i,int j,int[][] memo){
        if(i==s1.length()) return s2.length()-j;

        if(j==s2.length()) return s1.length()-i;

        if(memo[i][j]!=-1) return memo[i][j];


        if(s1.charAt(i)==s2.charAt(j)) {
            memo[i][j]=editDistance(s1, s2,i+1,j+1,memo);
        }
        else{
            int insert=1+editDistance(s1,s2,i,j+1,memo);
            int delete=1+editDistance(s1,s2,i+1,j,memo);
            int replace=1+editDistance(s1, s2,i+1,j+1,memo);

            memo[i][j] =Math.min(insert,Math.min(delete,replace));
        }


        return memo[i][j];
    }
}
