package lecture_14_binary_tree_2;

public class Diameter_Binary_Tree {

    static int height(BinaryTreeNode<Integer> root)
    {
        if(root==null) return 0;

        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        return 1+(Math.max(leftHeight,rightHeight));
    }

    public static int diameterTree(BinaryTreeNode<Integer> root)
    {
        if(root==null) return 0;

        int option1=height(root.left)+height(root.right);
        int option2=diameterTree(root.left);
        int option3=diameterTree(root.right);

        return Math.max(option1,Math.max(option2,option3));

    }
}
