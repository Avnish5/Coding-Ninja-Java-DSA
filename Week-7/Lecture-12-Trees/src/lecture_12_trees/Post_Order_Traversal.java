package lecture_12_trees;

public class Post_Order_Traversal {
    public static void printPostOrder(TreeNode<Integer> root){

        if(root==null) return;

        for(int i=0;i<root.children.size();i++) {
            printPostOrder(root.children.get(i));
        }

        System.out.print(root.data+" ");
    }
}
