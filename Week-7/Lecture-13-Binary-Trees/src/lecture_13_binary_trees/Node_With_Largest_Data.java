package lecture_13_binary_trees;

public class Node_With_Largest_Data {

    public static int largest(BinaryTreeNode<Integer> root)
    {
        if(root==null) return -1;


        int leftLargest=largest(root.left);
        int rightLargest=largest(root.right);

        return Math.max(root.data, Math.max(leftLargest, rightLargest));
    }
}
