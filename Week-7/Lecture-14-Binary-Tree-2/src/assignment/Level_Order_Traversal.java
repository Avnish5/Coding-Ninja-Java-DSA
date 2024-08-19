package assignment;

import lecture_14_binary_tree_2.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
/*
Problem statement
For a given a Binary Tree of type integer, print it in a level order fashion where each level will be printed on a new line. Elements on every level will be printed in a linear fashion and a single space will separate them.
 Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1
Sample Output 1:
10
20 30
40 50 60
Sample Input 2:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
8
3 10
1 6 14
4 7 13
 */
public class Level_Order_Traversal {

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if(root==null) return;

        Queue<BinaryTreeNode<Integer>> pendingNodes=new LinkedList<>();
        pendingNodes.add(root);
        pendingNodes.add(null);

        while(!pendingNodes.isEmpty())
        {
            BinaryTreeNode<Integer> front=pendingNodes.remove();

            if(front!=null)
            {
                System.out.print(front.data+" ");
                if(front.left!=null) pendingNodes.add(front.left);
                if(front.right!=null) pendingNodes.add(front.right);
            }
            else{
                if(!pendingNodes.isEmpty())
                {
                    System.out.println();
                    pendingNodes.add(null);
                }
            }
        }
    }
}
