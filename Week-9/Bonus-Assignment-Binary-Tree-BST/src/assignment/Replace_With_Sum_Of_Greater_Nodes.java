package assignment;
/*
Problem statement
Given a binary search tree, you have to replace each node's data with the sum of all nodes which are greater or equal than it. You need to include the current node's data also.

That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) and all nodes whose data is greater than or equal to 5.

Note: You don't need to return or print, just change the data of each node.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1 :
18
36 10
38 31
25
 */
public class Replace_With_Sum_Of_Greater_Nodes {

    static class Accumulator{
        int sum;
    }

    public static void replaceWithLargerNodesSumHelper(BinaryTreeNode<Integer> root,Accumulator accumulator)
    {
        if(root==null) return;

        replaceWithLargerNodesSumHelper(root.right,accumulator);

        accumulator.sum+=root.data;
        root.data=accumulator.sum;

        replaceWithLargerNodesSumHelper(root.left,accumulator);

    }
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        Accumulator accumulator = new Accumulator();
        replaceWithLargerNodesSumHelper(root, accumulator);
    }
}
