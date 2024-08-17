package lecture_12_trees;

public class Node_With_Largest_Data {

    public static int largestNode(TreeNode<Integer> root) {
        if (root == null) return 0;

        int ans=root.data;

        for(int i=0;i<root.children.size();i++)
        {
            int childLargest=largestNode(root.children.get(i));
            if(childLargest>ans)
            {
                ans=childLargest;
            }
        }

        return ans;
    }
}
