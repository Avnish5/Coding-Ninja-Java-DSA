package lecture_12_trees;

public class Sum_Of_Nodes {
    public static int sumOfAllNode(TreeNode<Integer> root){
        if(root==null) return 0;

        int sum=root.data;

        for(TreeNode<Integer> child:root.children)
        {
            sum+=sumOfAllNode(child);
        }

        return sum;
    }
}

