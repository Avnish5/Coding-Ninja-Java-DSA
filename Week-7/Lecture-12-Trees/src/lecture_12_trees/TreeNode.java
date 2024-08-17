package lecture_12_trees;

import java.util.ArrayList;

public class TreeNode<T> {

    public T data;
    public ArrayList<TreeNode<T>> children;

    TreeNode(T data)
    {
        this.data=data;
        children=new ArrayList<>();
    }

}
