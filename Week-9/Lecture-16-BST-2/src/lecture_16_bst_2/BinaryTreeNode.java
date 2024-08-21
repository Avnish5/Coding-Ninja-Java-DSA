package lecture_16_bst_2;

public class BinaryTreeNode<T> {

   public  T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data)
    {
        this.data=data;
    }
}