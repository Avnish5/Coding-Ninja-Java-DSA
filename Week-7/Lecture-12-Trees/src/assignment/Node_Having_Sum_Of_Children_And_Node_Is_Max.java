package assignment;
/*
Problem statement
Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.

Input format :

Line 1 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : Node with maximum sum.
 */
import lecture_12_trees.TreeNode;

public class Node_Having_Sum_Of_Children_And_Node_Is_Max {
    static class MaxNodePair<T>{
        TreeNode<T> node;
        int sum;
    }

    public static MaxNodePair<Integer> maxNodeHelper(TreeNode<Integer> root)
    {
        if(root==null)
        {
            MaxNodePair<Integer> pair=new MaxNodePair<>();
            pair.node=null;
            pair.sum=Integer.MIN_VALUE;
            return pair;
        }

        int sum=root.data;

        for(TreeNode<Integer> child:root.children)
        {
            sum+=child.data;
        }

        MaxNodePair<Integer> ans=new MaxNodePair<>();
        ans.node=root;
        ans.sum=sum;

        for(TreeNode<Integer> child:root.children)
        {
            MaxNodePair<Integer> childAns=maxNodeHelper(child);

            if(childAns.sum>ans.sum)
            {
                ans=childAns;
            }
        }

        return ans;

    }
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        return maxNodeHelper(root).node;
    }
}
