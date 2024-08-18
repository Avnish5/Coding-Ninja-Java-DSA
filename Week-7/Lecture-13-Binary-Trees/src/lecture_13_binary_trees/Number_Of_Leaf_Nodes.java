package lecture_13_binary_trees;

public class Number_Of_Leaf_Nodes {
    public static int countLeaf(BinaryTreeNode<Integer> root) {
        if(root==null) return 0;

        int count=0;

        if(root.left==null&&root.right==null) return 1;

        return countLeaf(root.left)+countLeaf(root.right);
    }
}
