package assignment;

import lecture_16_bst_2.BinaryTreeNode;

public class LCA_Binary_Tree {

    static BinaryTreeNode<Integer> getLCAHelper(BinaryTreeNode<Integer> root, int a, int b)
    {
        if(root==null || root.data==a || root.data==b) return root;

        BinaryTreeNode<Integer> left=getLCAHelper(root.left, a, b);
        BinaryTreeNode<Integer> right=getLCAHelper(root.right, a, b);

        if(left==null)
        {
            return right;
        }
        else if(right==null)
        {
            return left;
        }
        else
        {
            return root;
        }


    }
    static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {

        BinaryTreeNode<Integer> ans=getLCAHelper(root,a,b);

        if(ans!=null)
        {
            return ans.data;
        }
        else{
            return -1;
        }

    }
}
