package lecture_16_bst_2;

public class BinarySearchTree {

    BinaryTreeNode<Integer> root;


    public BinaryTreeNode<Integer>  insertHelper(BinaryTreeNode<Integer> root,int data)
    {
        if(root==null)
        {
            BinaryTreeNode<Integer> newNode=new BinaryTreeNode<Integer>(data);
            return newNode;
        }

        if(data>root.data)
        {
            root.right=insertHelper(root.right,data);
        }
        else
        {
            root.left=insertHelper(root.left,data);
        }

        return root;
    }
    public void insert(int data) {
        //Implement the insert() function
        root=insertHelper(root,data);
    }

    private BinaryTreeNode<Integer> removeHelper(int data, BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }
        if(data < root.data){
            root.left = removeHelper(data, root.left);
            return root;
        }else if(data > root.data){
            root.right = removeHelper(data, root.right);
            return root;
        }else{ //data = root.data
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                //if both left and right are not null, pick minimum element from right subtree and make that as the root
                BinaryTreeNode<Integer> minNode = root.right;
                while(minNode.left!=null){
                    minNode = minNode.left;
                }
                root.data = minNode.data;
                root.right = removeHelper(minNode.data, root.right);
                return root;

            }

        }


    }

    public void remove(int data) {
        //Implement the remove() function
        root=removeHelper(data,root);
    }

    public void printTreeHelper(BinaryTreeNode<Integer> root){
        if (root == null) {
            return;
        }
        String toBePrinted = root.data + ":";
        if (root.left != null) {
            toBePrinted += "L:" + root.left.data + ",";
        }

        if (root.right != null) {
            toBePrinted += "R:" + root.right.data;
        }
        System.out.println(toBePrinted);
        printTreeHelper(root.left);
        printTreeHelper(root.right);
    }
    public void printTree() {
        printTreeHelper(root);
    }

    public boolean searchHelper(BinaryTreeNode<Integer> root,int data)
    {
        if(root==null) return false;

        if(root.data==data) return true;

        if(data>root.data)
        {
            return searchHelper(root.right,data);
        }
        else
        {
            return  searchHelper(root.left,data);
        }
    }
    public boolean search(int data) {

        return searchHelper(root,data);
    }



}
