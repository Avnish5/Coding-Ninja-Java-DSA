package lecture_14_binary_tree_2;

import java.util.HashMap;
import java.util.Map;

/*
Problem statement
For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.

Note:
Assume that the Binary Tree contains only unique elements.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^3
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
1 2 4 5 3 6 7
4 2 5 1 6 3 7
Sample Output 1:
1
2 3
4 5 6 7
Sample Input 2:
6
5 6 2 3 9 10
2 6 3 9 5 10
Sample Output 2:
5
6 10
2 3
9

 */
public class Construct_Tree_From_Preorder_Ans_Inorder {

    public static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder,int preStart,int preEnd, int[] inOrder,int inStart,int inEnd,Map<Integer,Integer> map)
    {
        if(preStart>preEnd || inStart>inEnd) return null;

        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(preOrder[preStart]);

        int inRoot=map.get(root.data);
        int numsLeft=inRoot-inStart;

        root.left=buildTreeHelper(preOrder,preStart+1,preStart+numsLeft,inOrder,inStart,inRoot-1,map);
        root.right=buildTreeHelper(preOrder,preStart+numsLeft+1,preEnd,inOrder,inRoot+1,inEnd,map);

        return root;
    }
    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<inOrder.length;i++)
        {
            map.put(inOrder[i],i);
        }

        return buildTreeHelper(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1,map);

    }
}
