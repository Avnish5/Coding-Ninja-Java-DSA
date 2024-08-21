package lecture_16_bst_2;

import java.util.ArrayList;
/*
Problem statement
Given a BST and an integer k. Find and return the path from the node with data k and root (if a node with data k is present in given BST) in a list. Return empty list otherwise.

Note: Assume that BST contains all unique elements.
 */

public class Find_Path_In_BST {

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){

        if(root==null) return null;

        if(root.data==data)
        {
            ArrayList<Integer> output=new ArrayList<Integer>();
            output.add(root.data);
            return output;
        }

        else if(data>root.data){
            ArrayList<Integer> outputRight=getPath(root.right,data);
            if(outputRight!=null)
            {
                outputRight.add(root.data);
                return outputRight;
            }
        }
        else if (data<root.data)
        {
            ArrayList<Integer> outputLeft=getPath(root.left,data);
            if(outputLeft!=null)
            {
                outputLeft.add(root.data);
                return outputLeft;
            }
        }
        return null;
    }
}
