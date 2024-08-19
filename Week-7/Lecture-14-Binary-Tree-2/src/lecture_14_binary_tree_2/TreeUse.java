package lecture_14_binary_tree_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {
    public static BinaryTreeNode<Integer> takeInput(Scanner s)
    {

        System.out.print("Enter root data: ");
        int rootData=s.nextInt();

        if(rootData==-1) return null;

        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);

        root.left=takeInput(s);
        root.right=takeInput(s);

        return root;
    }

    public static void print(BinaryTreeNode<Integer> root)
    {
        if(root==null) return;
        String to_be_printed=root.data+":";

        if(root.left!=null)
        {
            to_be_printed+=" L: "+root.left.data;
        }

        if(root.right!=null)
        {
            to_be_printed+=" R: "+root.right.data;
        }

        System.out.println(to_be_printed);
        print(root.left);
        print(root.right);
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise()
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter root data: ");
        int rootData=s.nextInt();

        if(rootData==-1) return null;
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingNodes=new LinkedList<>();
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty())
        {
            BinaryTreeNode<Integer> front=pendingNodes.remove();

            System.out.print("Enter the left child of "+front.data+": ");
            int leftChildData=s.nextInt();
            if(leftChildData!=-1)
            {
                BinaryTreeNode<Integer> leftChild=new BinaryTreeNode<Integer>(leftChildData);
                front.left=leftChild;
                pendingNodes.add(leftChild);
            }

            System.out.print("Enter the rightt child of "+front.data+": ");
            int rightChildData=s.nextInt();
            if(rightChildData!=-1)
            {
                BinaryTreeNode<Integer> rightChild=new BinaryTreeNode<Integer>(rightChildData);
                front.right=rightChild;
                pendingNodes.add(rightChild);
            }
        }

        return root;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {

        if(root==null) return;

        Queue<BinaryTreeNode<Integer>> pendingNodes=new LinkedList<>();
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty())
        {
            BinaryTreeNode<Integer> front=pendingNodes.remove();

            String to_be_printed=front.data+":";

            if(front.left!=null)
            {
                to_be_printed+="L:"+front.left.data+",";
                pendingNodes.add(front.left);
            }
            else{
                to_be_printed+="L:-1,";
            }

            if(front.right!=null)
            {
                to_be_printed+="R:"+front.right.data;
                pendingNodes.add(front.right);
            }
            else{
                to_be_printed+="R:-1";
            }

            System.out.println(to_be_printed);
        }

    }
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        if(root==null) return;

        int d=k-root.data;
        if(root.left==null&&root.right==null&&d==0)
        {


                System.out.println(root.data);
                return;

        }


        rootToLeafPathsSumToK(root.left, d);
        rootToLeafPathsSumToK(root.right, d);
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        BinaryTreeNode<Integer> root=takeInputLevelWise();
        print(root);
        rootToLeafPathsSumToK(root,13);
    }
}
