package lecture_13_binary_trees;

public class BinaryTreeNode<T> {

    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data)
    {
        this.data=data;
    }
}
