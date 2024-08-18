package lecture_12_trees;

import java.util.LinkedList;
import java.util.Queue;
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

    public static TreeNode<Integer> takeInputLevelWise()  {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the root node: ");
        int n=s.nextInt();
        TreeNode<Integer> root=new TreeNode<Integer>(n);

        Queue<TreeNode<Integer>> pendingNodes=new LinkedList<>();
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty())
        {

                TreeNode<Integer> frontNode=pendingNodes.remove();
                System.out.println("Enter the no of children for "+frontNode.data+": ");
                int childCount=s.nextInt();

                for(int i=0;i<childCount;i++)
                {
                    System.out.println("Enter the "+i+"th child of "+frontNode.data);
                    int childData=s.nextInt();
                    TreeNode<Integer> child=new TreeNode<>(childData);
                    frontNode.children.add(child);
                    pendingNodes.add(child);
                }



        }
        return root;

    }

    public static void printLevelWise(TreeNode<Integer> root)  {
        if(root==null) return;
        Queue<TreeNode<Integer>> q=new LinkedList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty())
        {
            TreeNode<Integer> node = q.poll();
            if(node != null)
            {
                System.out.print(node.data + " ");
                for(int i=0; i<node.children.size(); i++)
                    q.add(node.children.get(i));
            }
            else{
                System.out.println();
                if(!q.isEmpty())
                    q.add(null);
            }
        }

    }

    public static void main(String[] args) throws QueueEmptyException {

        TreeNode<Integer> root=takeInputLevelWise();
        printLevelWise(root);
    }
}
