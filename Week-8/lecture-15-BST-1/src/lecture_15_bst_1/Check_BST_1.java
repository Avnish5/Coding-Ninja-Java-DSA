package lecture_15_bst_1;

public class Check_BST_1 {

    static int maximum(BinaryTreeNode<Integer> root)
    {
        if(root==null) return Integer.MIN_VALUE;

        return Math.max(root.data,Math.max(maximum(root.left),maximum(root.right)));
    }

    static int minimum(BinaryTreeNode<Integer> root){
        if(root==null) return Integer.MAX_VALUE;

        return Math.min(root.data,Math.min(maximum(root.left),maximum(root.right)));
    }
    public static boolean isBST(BinaryTreeNode<Integer> root){
        if(root==null) return true;

        int leftMax=maximum(root.left);
        int rightMin=minimum(root.right);

        if(root.data<=leftMax) return false;
        if(root.data>rightMin) return  false;

        boolean isLeftBST=isBST(root.left);
        boolean isRightBST=isBST(root.right);

        if(isLeftBST&&isRightBST)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
