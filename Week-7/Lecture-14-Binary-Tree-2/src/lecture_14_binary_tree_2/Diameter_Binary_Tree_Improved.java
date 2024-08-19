package lecture_14_binary_tree_2;

public class Diameter_Binary_Tree_Improved {

    static class Pair{
        int height;
        int diameter;
    }

    static Pair helper(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            Pair ans=new Pair();
            ans.height=0;
            ans.diameter=0;
            return ans;
        }

        Pair leftAns=helper(root.left);
        Pair rightAns=helper(root.right);

        int height=1+(Math.max(leftAns.height,rightAns.height));

        Pair ans=new Pair();
        ans.height=height;
        ans.diameter=Math.max(leftAns.height+rightAns.height,Math.max(leftAns.diameter,rightAns.diameter));

        return ans;

    }
    public static int diameterTree(BinaryTreeNode<Integer> root)
    {
        return helper(root).diameter;
    }
}
