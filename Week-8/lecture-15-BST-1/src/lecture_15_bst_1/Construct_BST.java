package lecture_15_bst_1;
/*
Problem statement
Given a sorted integer array A of size n, which contains all unique elements. You need to construct a balanced BST from this input array. Return the root of constructed BST.

Note: If array size is even, take first mid as root.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
Sample Input 1:
7
1 2 3 4 5 6 7
Sample Output 1:
4 2 1 3 6 5 7
 */
public class Construct_BST {

    public static BinaryTreeNode<Integer> helper(int[] arr,int s,int e)
    {
        if(s>e) return null;

        int mid=(s+e)/2;

        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(arr[mid]);

        root.left=helper(arr,s,mid-1);
        root.right=helper(arr, mid+1, e);

        return root;
    }
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
        return helper(arr,0,n-1);
    }
}
