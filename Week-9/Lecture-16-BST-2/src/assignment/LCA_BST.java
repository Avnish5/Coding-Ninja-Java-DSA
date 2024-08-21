package assignment;

import lecture_16_bst_2.BinaryTreeNode;

public class LCA_BST {

    public static BinaryTreeNode<Integer> getLCAHelper(BinaryTreeNode<Integer> root,int a,int b)
    {
        if(root==null) return null;

        int curr=root.data;

        if(curr>a&&curr>b)
        {
            return getLCAHelper(root.left,a,b);
        }
        if(curr<a&&curr<b)
        {
            return getLCAHelper(root.right,a,b);
        }

        return root;

    }
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        BinaryTreeNode<Integer> ans=getLCAHelper(root,a,b);

        if(ans!=null)
        {
            return ans.data;
        }
        else
        {
            return -1;
        }
    }
}
