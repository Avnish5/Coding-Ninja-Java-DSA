package assignment;

import java.util.Stack;

public class Count_Bracket_Reversals {
    public static int countBracketReversals(String input) {

        int len=input.length();

        if(len==0) return 0;
        if(len%2!=0) return -1;

        Stack<Character> s=new Stack<>();

        for(int i=0;i<input.length();i++)
        {
            char c=input.charAt(i);

            if(c=='{')
            {
                s.push(c);
            }
            else{
                if(!s.isEmpty()&&s.peek()=='{')
                {
                    s.pop();
                }
                else{
                    s.push(c);
                }
            }
        }

        int count=0;

        while(!s.isEmpty())
        {
            char c1=s.pop();
            char c2=s.pop();

            if(c1==c2)
            {
                count+=1;
            }
            else{
                count+=2;
            }

        }

        return count;
    }
}
