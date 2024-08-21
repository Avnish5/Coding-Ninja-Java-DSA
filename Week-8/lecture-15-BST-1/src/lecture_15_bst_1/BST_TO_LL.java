package lecture_15_bst_1;
/*
Problem statement
Given a BST, convert it into a sorted linked list. You have to return the head of LL.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
1<=n<=10^5
 */
public class BST_TO_LL {

    static class Pair{
        LinkedListNode<Integer> head;
        LinkedListNode<Integer> tail;
    }

    public static Pair helper(BinaryTreeNode<Integer> root){
        if(root==null)
        {
            Pair output=new Pair();
            output.head=null;
            output.tail=null;
            return output;
        }
        Pair lefttree=helper(root.left);
        LinkedListNode<Integer> newNode=new LinkedListNode<>(root.data);
        Pair righttree=helper(root.right);
        Pair output=new Pair();
        if(lefttree.head!=null)
        {
            output.head=lefttree.head;
            lefttree.tail.next=newNode;

        }
        else {
            output.head=newNode;
        }
        newNode.next=righttree.head;
        if(righttree.head==null)
        {
            output.tail=newNode;

        }
        else{
            output.tail=righttree.tail;
        }
        return output;
    }
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {

        return helper(root).head;


    }
}
