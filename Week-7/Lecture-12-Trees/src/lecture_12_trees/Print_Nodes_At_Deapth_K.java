package lecture_12_trees;

public class Print_Nodes_At_Deapth_K {

    public static void depthK(TreeNode<Integer> root,int k) {
        if(k<0) return ;

        if(k==0)
        {
            System.out.print(root.data+" ");
        }

        for(int i=0;i<root.children.size();i++) {
            depthK(root.children.get(i),k-1);
        }
    }

}
