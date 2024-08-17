package lecture_12_trees;

public class Count_Leaf_Nodes {
    public static int countLeafNodes(TreeNode<Integer> root){
         if(root == null) return 0;


         int count = 0;
        if(root.children.size() == 0)
            count++;
        for(TreeNode<Integer> child : root.children)
            count += countLeafNodes(child);
        return count;

    }
}
