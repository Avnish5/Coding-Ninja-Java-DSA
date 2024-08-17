package lecture_12_trees;

import java.util.Scanner;

public class TreeUse {

    public static TreeNode<Integer> takeInput()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter next node data");
        int n=s.nextInt();
         TreeNode<Integer> root=new TreeNode<Integer>(n);
        System.out.println("Enter the no of children for "+ n);
        int childCount=s.nextInt();

        for(int i=0;i<childCount;i++)
        {
            TreeNode<Integer> child=takeInput();
            root.children.add(child);

        }

        return root;

    }

    public static void print(TreeNode<Integer> root)
    {
        if(root==null) return;

        System.out.print(root.data+": ");

        for(int i=0;i<root.children.size();i++)
        {
            System.out.print(root.children.get(i).data+",");
        }
        System.out.println();

        for(int i=0;i<root.children.size();i++)
        {
            print(root.children.get(i));
        }

    }

    public static void main(String[] args) {

        TreeNode<Integer> root=takeInput();
        print(root);
    }
}
