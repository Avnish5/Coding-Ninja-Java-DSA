package lecture_13_binary_trees;
/*
Problem statement
For a given Binary Tree of integers, find and return the height of the tree. Height is defined as the total number of nodes along the longest path from the root to any of the leaf node.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 -1 -1 -1 -1 -1
Sample Output 1:
3
Sample Input 2:
3 -1 -1
Sample Output 2:

 */
public class Find_Height {
    public static int height(BinaryTreeNode<Integer> root) {

        if(root==null) return 0;


        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        return (Math.max(leftHeight, rightHeight)+1);
    }
}
