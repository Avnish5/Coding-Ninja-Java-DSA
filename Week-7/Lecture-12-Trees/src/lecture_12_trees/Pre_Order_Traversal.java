package lecture_12_trees;

public class Pre_Order_Traversal {
    public static void printPreOrder(TreeNode<Integer> root){

        if(root==null) return;

        System.out.print(root.data+" ");

        for(int i=0;i<root.children.size();i++) {
            printPreOrder(root.children.get(i));
        }
    }
}
