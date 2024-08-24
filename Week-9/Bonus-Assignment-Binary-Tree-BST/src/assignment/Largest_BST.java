package assignment;
/*
Problem statement
Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree. You have to return the height of largest BST.
 */
public class Largest_BST {

    static class BstReturn{
        int maximum;
        int minimum;
        int height;
        boolean isBST;
    }

    public static  BstReturn  largestBSTSubtreeHelper(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            BstReturn output=new BstReturn();
            output.minimum=Integer.MAX_VALUE;
            output.maximum=Integer.MIN_VALUE;
            output.height=0;
            output.isBST=true;
            return output;
        }

        BstReturn leftOutput=largestBSTSubtreeHelper(root.left);
        BstReturn rightOutput=largestBSTSubtreeHelper(root.right);

        int min=Math.min(root.data,Math.min(leftOutput.minimum,rightOutput.minimum));
        int max=Math.max(root.data,Math.max(leftOutput.maximum,rightOutput.maximum));
        int height=1+Math.max(leftOutput.height,rightOutput.height);

        boolean isBST=(root.data>leftOutput.maximum) && (root.data<=rightOutput.minimum) && leftOutput.isBST && rightOutput.isBST;


        BstReturn ans=new BstReturn();
        ans.minimum=min;
        ans.maximum=max;

        if(isBST)
        {
            ans.isBST=true;
            ans.height=height;
        }
        else{
            ans.isBST=false;
            ans.height=Math.max(leftOutput.height,rightOutput.height);
        }

        return ans;
    }


    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        return largestBSTSubtreeHelper(root).height;
    }
}
