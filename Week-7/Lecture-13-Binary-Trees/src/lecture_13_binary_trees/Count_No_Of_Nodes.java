package lecture_13_binary_trees;

public class Count_No_Of_Nodes {

    public static int count(BinaryTreeNode<Integer> root)
    {
        if(root==null) return 0;

        int count=1;
        count+=count(root.left);
        count+=count(root.right);

        return count;
    }
}
