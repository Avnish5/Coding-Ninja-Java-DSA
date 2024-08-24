package assignment;

import java.util.ArrayList;

/*
Problem statement
You are given a Binary Tree of type integer, a integer value of target node's data, and an integer value K.

Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.
 */
public class Print_Node_At_Distance_k_From_Target_Node {

    public static boolean  findPath(BinaryTreeNode<Integer> root,int  target,ArrayList<BinaryTreeNode<Integer>> path)
    {
        if(root==null) return false;

        if(root.data==target)
        {
            path.add(root);
            return true;
        }

        if(findPath(root.left, target, path) || findPath(root.right, target, path))
        {
            path.add(root);
            return true;
        }

        return false;
    }

    public static void printNodesAtDistanceK(BinaryTreeNode<Integer> root,int k,BinaryTreeNode<Integer> blocker)
    {
        if(root==null || k<0 || root==blocker) return;
        if(k==0)
        {
            System.out.println(root.data);
        }

        printNodesAtDistanceK(root.left,k-1,blocker);
        printNodesAtDistanceK(root.right,k-1,blocker);


    }
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        ArrayList<BinaryTreeNode<Integer>> path=new ArrayList<>();

        findPath(root, node, path);

        for(int i=0;i<path.size();i++)
        {
            printNodesAtDistanceK(path.get(i),k-i,i==0?null:path.get(i-1));
        }
    }
}
