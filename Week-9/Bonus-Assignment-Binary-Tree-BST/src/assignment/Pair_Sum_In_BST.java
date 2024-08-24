package assignment;

import java.util.ArrayList;
import java.util.Collections;

/*
Problem statement
Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space of the order of O(log n).

Note:
1. Assume BST contains all unique elements.
2. In a pair, print the smaller element first.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 1:
2 10
5 7
 */
public class Pair_Sum_In_BST {

    public static void inOrder(ArrayList<Integer> list,BinaryTreeNode<Integer> root)
    {
        if(root==null) return;
        inOrder(list,root.left);
        list.add(root.data);
        inOrder(list,root.right);
    }
    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int sum) {

        ArrayList<Integer> list=new ArrayList<>();
        inOrder(list,root);
        Collections.sort(list);

        int s=0,e=list.size()-1;

        while(s<e)
        {
            if(list.get(s)+list.get(e)>sum)
            {
                e--;
            }
            else if(list.get(s)+list.get(e)<sum)
            {
                s++;
            }
            else{
                System.out.println(list.get(s)+" "+list.get(e));
                s++;
                e--;
            }
        }


    }
}
