package lecture_15_bst_1;
/*
Problem statement
Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).

Print the elements in increasing order.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
6 10
Sample Output 1:
6 7 8 10
 */
public class Elements_In_Range {

    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){


        if(root==null) return;

        if(k2<root.data)
        {
            elementsInRangeK1K2(root.left,k1,k2);
        }
        else if(k1>root.data)
        {
            elementsInRangeK1K2(root.right,k1,k2);
        }
        else
        {
            elementsInRangeK1K2(root.left,k1,k2);
            System.out.print(root.data+" ");
            elementsInRangeK1K2(root.right,k1,k2);
        }
    }
}
