package lecture_12_trees;

public class Find_No_Of_Nodes {
    public static int find(TreeNode<Integer> root) {
        if (root == null) return 0;

        int count=1;

        for(int i=0;i<root.children.size();i++)
        {
            count+=find(root.children.get(i));
        }
        return count;
    }
}
