package lecture_14_binary_tree_2;

import java.util.HashMap;
import java.util.Map;

/*
Problem statement
For a given postorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.

Note:
Assume that the Binary Tree contains only unique elements.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^4
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
4 5 2 6 7 3 1
4 2 5 1 6 3 7
Sample Output 1:
1
2 3
4 5 6 7
Sample Input 2:
6
2 9 3 6 10 5
2 6 3 9 5 10
Sample Output 2:
5
6 10
2 3
9

 */
public class Construct_Tree_From_Postorder_Ans_Inorder {

    public static BinaryTreeNode<Integer> buildTreeHelper(int[] postOrder,int postStart,int postEnd, int[] inOrder,int inStart,int inEnd,Map<Integer,Integer> map)
    {
        if(postStart>postEnd || inStart>inEnd) return null;

        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(postOrder[postEnd]);

        int inRoot=map.get(root.data);
        int numsLeft=inRoot-inStart;

        root.left=buildTreeHelper(postOrder,postStart,postStart+numsLeft-1,inOrder,inStart,inRoot-1,map);
        root.right=buildTreeHelper(postOrder,postStart+numsLeft,postEnd-1,inOrder,inRoot+1,inEnd,map);

        return root;
    }
    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<inOrder.length;i++)
        {
            map.put(inOrder[i],i);
        }

        return buildTreeHelper(postOrder, 0, postOrder.length-1, inOrder, 0, inOrder.length-1, map);
    }
}
