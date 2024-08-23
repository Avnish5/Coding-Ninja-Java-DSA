package assignment;

import lecture_14_binary_tree_2.BinaryTreeNode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.HashSet;

/*
Problem statement
You are given a Binary Tree of type integer, a integer value of target node's data, and an integer value K.

Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.
1 ≤ data of node ≤ 10^9
1 ≤ target ≤ 10^9

Time Limit: 1 sec
Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
3 1
Sample Output 1:
9
6
Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
3 3
Sample Output 2:
4
5
 */
public class Print_Nodes_At_Distance_K_From_Node {

    public static  BinaryTreeNode<Integer> findTargetNode(BinaryTreeNode<Integer> root, int node)
    {
        if(root==null) return null;

        if(root.data==node) return root;

        BinaryTreeNode<Integer> left=findTargetNode(root.left,node);
        if(left!=null) return left;

        BinaryTreeNode<Integer> right=findTargetNode(root.right,node);
        return right;
    }

    public static void findParent(BinaryTreeNode<Integer> root,HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> hm)
    {
        if(root==null) return;

        if(root.left!=null)
        {
            hm.put(root.left,root);
        }

        if(root.right!=null)
        {
            hm.put(root.right,root);
        }

        findParent(root.left,hm);
        findParent(root.right,hm);

    }

    public static  List<Integer> distanceK(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> target,int k)
    {
        List<Integer> res=new ArrayList<>();
        HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> parentMap=new HashMap<>();
        findParent(root,parentMap);

        Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
        HashSet<BinaryTreeNode<Integer>>  visited = new HashSet<>();
        q.add(target);



        while(!q.isEmpty())
        {
            int size=q.size();

            for(int i=0;i<size;i++)
            {
                BinaryTreeNode<Integer> curr=q.poll();
                visited.add(curr);

                if(k==0)
                {
                    res.add(curr.data);
                }

                if(parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))){
                    q.add(parentMap.get(curr));
                }

                if(curr.left != null && !visited.contains(curr.left)){
                    q.add(curr.left);
                }

                if(curr.right != null && !visited.contains(curr.right)){
                    q.add(curr.right);
                }
            }
            k--;
            if(k<0) break;
        }

        return res;

    }
    public  static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        BinaryTreeNode<Integer> target=findTargetNode(root, node);
        List<Integer> res=distanceK(root,target,k);

        for(int i:res)
        {
            System.out.println(i);
        }


    }
}
