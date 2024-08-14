package lecture_10_stack;

import java.util.Stack;

public class Balanced_Paranthesis {
    public static boolean isBalanced(String expression) {
        Stack<Character> s=new Stack<>();

        for(int i=0;i<expression.length();i++)
        {
            char c=expression.charAt(i);

            if(c=='['||c=='{'||c=='(')
            {
                s.push(c);
            }
            else if(c==']'||c=='}'||c==')')
            {
                if(s.isEmpty())
                {
                    return false;
                }
                else if(c==']')
                {
                    if(s.peek()!='[')
                    {
                        return false;
                    }
                    else{
                        s.pop();
                    }
                }
                else if(c=='}')
                {
                    if(s.peek()!='{')
                    {
                        return false;
                    }
                    else{
                        s.pop();
                    }
                }
                else if(c==')')
                {
                    if(s.peek()!='(')
                    {
                        return false;
                    }
                    else{
                        s.pop();
                    }
                }
            }
        }

        return s.isEmpty();
    }
}
