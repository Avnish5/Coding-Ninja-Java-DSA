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

    public static TreeNode<Integer> takeInputLevelWise()  {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the root node: ");
        int n=s.nextInt();
        TreeNode<Integer> root=new TreeNode<Integer>(n);

        QueueUsingLL<TreeNode<Integer>> pendingNodes=new QueueUsingLL<>();
        pendingNodes.enqueue(root);

        while(!pendingNodes.isEmpty())
        {
            try{
                TreeNode<Integer> frontNode=pendingNodes.dequeue();
                System.out.println("Enter the no of children for "+frontNode.data+": ");
                int childCount=s.nextInt();

                for(int i=0;i<childCount;i++)
                {
                    System.out.println("Enter the "+i+"th child of "+frontNode.data);
                    int childData=s.nextInt();
                    TreeNode<Integer> child=new TreeNode<>(childData);
                    frontNode.children.add(child);
                    pendingNodes.enqueue(child);
                }

            }
            catch (QueueEmptyException  e)
            {
                return null;
            }
        }
        return root;

    }

    public static void printLevelWise(TreeNode<Integer> root) throws QueueEmptyException {
        if(root==null) return;

        QueueUsingLL<TreeNode<Integer>> pendingNodes=new QueueUsingLL<>();
        pendingNodes.enqueue(root);

        while(!pendingNodes.isEmpty())
        {
            TreeNode<Integer> frontNode=pendingNodes.dequeue();
            System.out.print(frontNode.data+":");

            for(int i=0;i<frontNode.children.size();i++)
            {
                System.out.print(frontNode.children.get(i).data+",");
                pendingNodes.enqueue(frontNode.children.get(i));
            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws QueueEmptyException {

        TreeNode<Integer> root=takeInputLevelWise();
        printLevelWise(root);
    }
}
