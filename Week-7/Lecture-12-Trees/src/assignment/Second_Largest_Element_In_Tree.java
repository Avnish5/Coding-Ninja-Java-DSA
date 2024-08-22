package assignment;

import lecture_12_trees.TreeNode;

public class Second_Largest_Element_In_Tree {

    static class Result{
        TreeNode<Integer> largest=null;
        TreeNode<Integer> secondLargest=null;
    }
    public static TreeNode<Integer> findSecondLargestHelper(TreeNode<Integer> root)
    {
        Result result=new Result();
        traverse(root,result);
        if(result.largest!=null && result.secondLargest!=null && result.largest.data==result.secondLargest.data) return null;
        return result.secondLargest;
    }

    public static void traverse(TreeNode<Integer> root,Result result)
    {
        if(root==null) return;

        if(result.largest!=null && result.secondLargest!=null && result.largest.data==result.secondLargest.data  )
        {
            result.secondLargest=root;
        }
        else if(result.largest==null  || root.data>result.largest.data)
        {
            result.secondLargest=result.largest;
            result.largest=root;
        }
        else if(result.secondLargest==null || root.data>result.secondLargest.data&&root.data<result.largest.data)
        {
            result.secondLargest=root;
        }

        for(TreeNode<Integer> child:root.children)
        {
            traverse(child, result);
        }
    }
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){

        if(root==null) return root;
        return findSecondLargestHelper(root);


    }
}
