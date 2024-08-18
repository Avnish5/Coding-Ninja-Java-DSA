package lecture_13_binary_trees;
/*
Problem statement
For a given Binary Tree of integers, find and return the sum of all the nodes data.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^6
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
2 3 4 6 -1 -1 -1 -1 -1
Sample Output 1:
 15
Explanation :
The binary tree formed using the input values: 2, 3, 4, 6, -1, -1, -1, -1, -1. Hence the sum is 15
 */
public class Sum_No_Of_Nodes {
    public static int getSum(BinaryTreeNode<Integer> root) {

        if(root==null) return 0;

        int sum=root.data;
        sum+=getSum(root.left);
        sum+=getSum(root.right);

        return sum;
    }
}
