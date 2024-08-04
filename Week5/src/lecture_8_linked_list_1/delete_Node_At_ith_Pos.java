package lecture_8_linked_list_1;
/*
Problem statement
You have been given a linked list of integers. Your task is to write a function that deletes a node from a given position, 'POS'.

Note :
Assume that the Indexing for the linked list always starts from 0.

If the position is greater than or equal to the length of the linked list, you should return the same linked list without any change.

Sample Input 1 :
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
3 4 5 6 1 9
Explanation of Sample Output 1 :
The data in the node with index 3 is 2 which has been removed.
Sample Input 2 :
3 4 5 2 6 1 9 -1
0
Sample Output 2 :
4 5 2 6 1 9
Constraints :
0 <= N <= 10^5
POS >= 0

Time Limit: 1sec
Expected Complexity :
Time Complexity  : O(N)
Space Complexity  : O(1)

 */
public class delete_Node_At_ith_Pos {

    public static Node<Integer> deleteNode( Node<Integer> head, int pos) {

        if(head==null)
        {
            return head;
        }

        if(pos==0)
        {
            return head.next;
        }


        Node<Integer> temp=head;
        for(int i=0;i<pos-1&&temp!=null;i++)
        {
            temp=temp.next;
        }

        if(temp==null||temp.next==null) return head;

        temp.next=temp.next.next;
        return head;

    }
}
