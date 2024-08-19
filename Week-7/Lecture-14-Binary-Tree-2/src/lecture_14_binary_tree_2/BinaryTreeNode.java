package lecture_14_binary_tree_2;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    BinaryTreeNode(T data)
    {
        this.data=data;
    }
}
