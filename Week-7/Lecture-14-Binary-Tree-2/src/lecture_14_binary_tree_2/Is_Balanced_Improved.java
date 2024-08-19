package lecture_14_binary_tree_2;

public class Is_Balanced_Improved {

    static class BalancedTreeReturn{

        int height;
        boolean isBal;
    }

    static BalancedTreeReturn  helper(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            BalancedTreeReturn output=new BalancedTreeReturn();
            output.height=0;
            output.isBal=true;
            return output;
        }

        BalancedTreeReturn leftOutput=helper(root.left);
        BalancedTreeReturn rightOutput=helper(root.right);

        int height=1+(Math.max(leftOutput.height,rightOutput.height));
        boolean isBal=true;

        if(Math.abs(leftOutput.height-rightOutput.height)>1)
        {
            isBal=false;
        }

        if(!leftOutput.isBal || !rightOutput.isBal)
        {
            isBal=false;
        }

        BalancedTreeReturn ans=new BalancedTreeReturn();
        ans.height=height;
        ans.isBal=isBal;

        return ans;

    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root)
    {
        return helper(root).isBal;
    }
}
