package assignment;

import lecture_16_bst_2.BinaryTreeNode;

/*
Problem statement
For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.

The root will remain the same. So you just need to insert nodes in the given Binary Tree.
 */
public class Create_And_Insert_Duplicate_Node {

    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if(root==null) return;


        BinaryTreeNode<Integer> newNode=new BinaryTreeNode<Integer>(root.data);
        BinaryTreeNode<Integer> temp=root.left;
        root.left=newNode;
        newNode.left=temp;

        insertDuplicateNode(newNode.left);
        insertDuplicateNode(root.right);

    }
}
