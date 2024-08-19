package lecture_14_binary_tree_2;
/*
Problem statement
For a given Binary Tree of type integer, update it with its corresponding mirror image.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
1
3 2
7 6 5 4
Sample Input 2:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 2:
5
6 10
3 2
9

 */
public class Mirror_Binary_Tree {

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
        if(root==null) return;

        BinaryTreeNode<Integer>  temp=root.left;
        root.left=root.right;
        root.right=temp;

        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);

    }
}
