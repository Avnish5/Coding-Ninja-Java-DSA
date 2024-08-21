package lecture_15_bst_1;

public class Check_BST_3 {

    public static boolean helper(BinaryTreeNode<Integer> root,int min,int max){
        if(root==null) return true;

        if(root.data<min || root.data>max) return false;

        boolean left=helper(root.left,min,root.data-1);
        boolean right=helper(root.right,root.data,max);

        return left&&right;
    }

    public static boolean isBST(BinaryTreeNode<Integer> root){
        return helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
