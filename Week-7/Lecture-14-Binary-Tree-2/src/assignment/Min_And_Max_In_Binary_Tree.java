package assignment;

import lecture_14_binary_tree_2.BinaryTreeNode;

/*
Problem statement
For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.

Return the output as an object of Pair class, which is already created.

Note:
All the node data will be unique and hence there will always exist a minimum and maximum node data.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
2 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
1 14
Sample Input 2:
10 20 60 -1 -1 3 50 -1 -1 -1 -1
Sample Output 2:
3 60

      if(root==null)
	  {
		  Pair<Integer, Integer> pair=new Pair<>(Integer.MAX_VALUE,Integer.MIN_VALUE);
			return pair;
	  }
		if(root.left==null&&root.right==null)
		{
			Pair<Integer, Integer> pair=new Pair<>(root.data,root.data);
			return pair;


 */
public class Min_And_Max_In_Binary_Tree {

    static class Pair<T, U> {
        T minimum;
        U maximum;

        public Pair(T minimum, U maximum) {
            this.minimum = minimum;
            this.maximum = maximum;
        }

    }

    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {

        if(root==null)
        {
            Pair<Integer, Integer> pair=new Pair<>(Integer.MAX_VALUE,Integer.MIN_VALUE);
            return pair;
        }
        if(root.left==null&&root.right==null)
        {
            Pair<Integer, Integer> pair=new Pair<>(root.data,root.data);
            return pair;
        }

        Pair<Integer, Integer> leftPair=getMinAndMax(root.left);
        Pair<Integer, Integer> rightPair=getMinAndMax(root.right);

        int Maximum=Math.max(root.data, Math.max(leftPair.maximum,rightPair.maximum));
        int Minimum=Math.min(root.data, Math.min(leftPair.minimum,rightPair.minimum));

        Pair<Integer, Integer> pair=new Pair<>(Minimum,Maximum);


        return pair;

    }
}
