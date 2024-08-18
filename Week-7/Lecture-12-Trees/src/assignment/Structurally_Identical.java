package assignment;

import lecture_12_trees.TreeNode;

/*
Problem statement
Given two Generic trees, return true if they are structurally identical i.e. they are made of nodes with the same values arranged in the same way.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0
10 3 20 30 40 2 40 50 0 0 0 0
Sample Output 1 :
true
Explanation
If we draw the tree for the above inputs, both the trees will look like this. So the answer for this is true.
 */
public class Structurally_Identical {
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

        if(root1.children.size()!=root2.children.size()) return false;
        if(root1.data!=root2.data) return false;

        for(int i=0;i<root1.children.size();i++)
        {
            boolean flag=checkIdentical(root1.children.get(i), root2.children.get(i));

            if(!flag) return flag;
        }

        return true;


    }
}
