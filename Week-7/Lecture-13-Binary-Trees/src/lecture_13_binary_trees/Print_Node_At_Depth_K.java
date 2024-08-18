package lecture_13_binary_trees;

public class Print_Node_At_Depth_K {

    public static void printAtDepthK(BinaryTreeNode<Integer> root,int k) {
        if(root==null||k<0) return;

        if(k==0)
        {
            System.out.print(root.data+" ");
        }

        printAtDepthK(root.left,k-1);
        printAtDepthK(root.right,k-1);

    }
}
