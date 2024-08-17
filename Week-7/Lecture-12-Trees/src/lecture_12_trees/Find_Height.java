package lecture_12_trees;

public class Find_Height {
    public static int getHeight(TreeNode<Integer> root){

        if(root==null) return 0;

        int h=0;

        for(int i=0;i<root.children.size();i++)
        {
            int childHeight=getHeight(root.children.get(i));

            if(childHeight>h)
            {
                h=childHeight;
            }
        }

        return h+1;

    }
}
