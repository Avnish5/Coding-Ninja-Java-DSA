package assignment;

import java.util.ArrayList;

public class StariCase {

    public static  ArrayList<String> printStaircase(int n)
    {
        if(n==0)
        {
            ArrayList<String> output=new ArrayList<>();
            output.add("");
            return output;
        }

        if(n<0)
        {
            ArrayList<String> output=new ArrayList<>();
            return output;
        }

        ArrayList<String> path1=printStaircase(n-1);
        ArrayList<String> path2=printStaircase(n-2);
        ArrayList<String> path3=printStaircase(n-3);
        ArrayList<String> paths=new ArrayList<>();

        for(String path:path1)
        {
            paths.add(1+path);
        }
        for(String path:path2)
        {
            paths.add(2+path);
        }
        for(String path:path3)
        {
            paths.add(3+path);
        }

     return paths;

    }

    public static int staircase(int n){

        if(n==0) return 1;
        if(n<0) return 0;
        return staircase(n-1)+staircase(n-2)+staircase(n-3);

    }


}
