package assignment;

import lecture_14_binary_tree_2.BinaryTreeNode;

/*
Problem statement
For a given Binary Tree of type integer and a number K, print out all root-to-leaf paths where the sum of all the node data along the path is equal to K.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
2 3 9 4 8 -1 2 4 -1 -1 -1 6 -1 -1 -1 -1 -1
13
 Sample Output 1:
2 3 4 4
2 3 8
Sample Input 2:
5 6 7 2 3 -1 1 -1 -1 -1 9 -1 -1 -1 -1
13
 Sample Output 2:
5 6 2
5 7 1
 */
public class Path_Sum_Root_To_Leaf {

    public static void helper(BinaryTreeNode<Integer> root, int k, String path)
    {
        if(root==null) return;

        int remainingValue=k-root.data;
        path=path+root.data+" ";
        if(root.left==null&&root.right==null&&remainingValue==0)
        {
            System.out.println(path);
            return;
        }
        helper(root.left,remainingValue,path);
        helper(root.right,remainingValue,path);
    }
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {

        String path="";
        helper(root,k,path);
    }
}
