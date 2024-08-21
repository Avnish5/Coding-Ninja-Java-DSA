package assignment;

import lecture_16_bst_2.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;

/*
Problem statement
Given a binary tree and an integer S, print all the pair of nodes whose sum equals S.

Note:

1. Assume the given binary tree contains all unique elements.
2. In a pair, print the smaller element first. Order of different pairs doesn't matter.
 */
public class Pair_Sum_Binary_Tree {

    public static void convertToArray(BinaryTreeNode<Integer> root,ArrayList<Integer> arr)
    {
        if(root==null) return;

        convertToArray(root.left,arr);
        arr.add(root.data);
        convertToArray(root.right,arr);
    }
    public static void pairSum(BinaryTreeNode<Integer> root, int sum) {

        ArrayList<Integer> arr=new ArrayList<>();
        convertToArray(root,arr);
        Collections.sort(arr);

        int s=0,e=arr.size()-1;

        while(s<e)
        {
            if(arr.get(s)+arr.get(e)<sum)
            {
                s++;
            }
            else if(arr.get(s)+arr.get(e)>sum)
            {
                e--;
            }
            else
            {

                System.out.println(arr.get(s)+" "+arr.get(e));
                s++;
                e--;
            }
        }
    }
}
