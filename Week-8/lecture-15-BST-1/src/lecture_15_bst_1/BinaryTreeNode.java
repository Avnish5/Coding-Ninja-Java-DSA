package lecture_15_bst_1;

public class BinaryTreeNode<T> {

    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data)
    {
        this.data=data;
    }
}
