package assignment;

import lecture_12_trees.TreeNode;

/*
Problem statement
In a given Generic Tree, replace each node with its depth value. You need to just update the data of each node, no need to return or print anything. Depth of a node is defined as the distance of the node from root. You may assume that depth of root node is 0.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0

Sample Output 1 : (Level wise, each level in new line)
0
1 1 1
2 2
Explanation
Since root is 10 , so it's depth is 0
Node 20, 30 , 40 are present at 1st level , so their depth is 1.
Node 40,50 are present at 2nd level, so their depth is 2.
 */
public class Replace_With_Depth_Value {

    public static void help(TreeNode<Integer> root, int k){

        if(root==null) return;

        root.data=k;

        for(int i=0;i<root.children.size();i++)
        {
            help(root.children.get(i),k+1);
        }
    }

    public static void replaceWithDepthValue(TreeNode<Integer> root){

        // Write your code here
        help(root,0);

    }
}
