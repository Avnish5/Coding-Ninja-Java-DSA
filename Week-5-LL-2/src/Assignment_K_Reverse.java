/*
Problem statement
Given a singly linked list of integers, reverse the nodes of the linked list 'k' at a time and return its modified list.

 'k' is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of 'k,' then left-out nodes, in the end, should be reversed as well.

Example :
Given this linked list: 1 -> 2 -> 3 -> 4 -> 5

For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5

For k = 3, you should return: 3 -> 2 -> 1 -> 5 -> 4
 Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= k <= M

Time Limit:  1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 9 10 -1
4


Sample Output 1 :
4 3 2 1 8 7 6 5 10 9
Sample Input 2 :
2
1 2 3 4 5 -1
0
10 20 30 40 -1
4
Sample Output 2 :
1 2 3 4 5
40 30 20 10


 */
public class Assignment_K_Reverse {
    public static Node<Integer> kReverse(Node<Integer> head, int k) {

        if(head==null||head.next==null||k==0) return head;

        Node<Integer> curr=head,nex=null,prev=null;
        int count=0;

        while(count<k&&curr!=null)
        {
            nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
            count++;
        }

        if(nex!=null)
        {
            head.next=kReverse(nex, k);
        }

        return prev;
    }
}
