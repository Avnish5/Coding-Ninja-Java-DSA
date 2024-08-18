package lecture_12_trees;

public class Find_No_Of_Nodes {
    public static int find(TreeNode<Integer> root) {
        if (root == null) return 0;

        int count=1;

        for(TreeNode<Integer> child:root.children)
        {
            count+=find(child);
        }
        return count;
    }
}
