package lecture_8_linked_list_1;
/*

Problem statement
For a given a singly linked list of integers and a position 'i', print the node data at the 'i-th' position.

 Note :
Assume that the Indexing for the singly linked list always starts from 0.

If the given position 'i',  is greater than the length of the given singly linked list, then don't print anything.
Detailed explanation ( Input/output format, Notes, Images )
 Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
i  >= 0
Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
2
Sample Input 2 :
2
3 4 5 2 6 1 9 -1
0
9 8 4 0 7 8 -1
3
Sample Output 2 :
3
*/


public class Print_Ith_Node {

    public static void printIthNode(Node<Integer> head, int i) {
        int position=0;
        Node<Integer>  temp=head;
        while(position<i&&temp!=null)
        {
            position++;
            temp=temp.next;
        }

        if(temp!=null)
        {
            System.out.println(temp.data);
        }
    }

}
