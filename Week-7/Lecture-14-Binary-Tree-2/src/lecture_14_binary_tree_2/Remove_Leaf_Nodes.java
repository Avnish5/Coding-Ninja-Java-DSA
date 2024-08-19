package lecture_14_binary_tree_2;

public class Remove_Leaf_Nodes {

    public static BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root)
    {
        if(root==null) return null;

        if(root.left==null&&root.right==null) return null;

        root.left=remove(root.left);
        root.right=remove(root.right);

        return root;
    }
}
