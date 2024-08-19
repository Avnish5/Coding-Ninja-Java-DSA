package lecture_14_binary_tree_2;

public class Is_Balanced {

   static int height(BinaryTreeNode<Integer> root)
    {
        if(root==null) return 0;

        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        return 1+(Math.max(leftHeight,rightHeight));
    }
    public static boolean isBalanced(BinaryTreeNode<Integer> root)
    {
        if(root==null) return true;

        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        if(Math.abs(leftHeight-rightHeight)>1) return false;

        boolean isLeftBalanced=isBalanced(root.left);
        boolean isRightBalanced=isBalanced(root.right);

        return isLeftBalanced && isRightBalanced;

    }
}
