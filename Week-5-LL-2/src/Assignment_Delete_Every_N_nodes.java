/*
Problem statement
You have been given a singly linked list of integers along with two integers, 'M,' and 'N.' Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes. Continue the same until the end of the linked list. Indexing starts from 1.

To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.

Note :
No need to print the list, it has already been taken care. Only return the new head to the list. You can return null in case where all nodes will be deleted.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= P <= 10^5
Where P is the size of the singly linked list.
0 <= M <= 10^5
0 <= N <= 10^5

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 -1
2 2
Sample Output 1 :
1 2 5 6
Sample Input 2 :
2
10 20 30 40 50 60 -1
0 1
1 2 3 4 5 6 7 8 -1
2 3
Sample Output 2 :
1 2 6 7
Explanation of Sample Input 2 :
For the first query, we delete one node after every zero elements hence removing all the items of the list. Therefore, nothing got printed.

For the second query, we delete three nodes after every two nodes, resulting in the final list, 1 -> 2 -> 6 -> 7
 */
public class Assignment_Delete_Every_N_nodes {
    public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
        //Your code goes here
        if(head==null || M==0) return null;
        if(N==0) return head;


        Node<Integer> curr=head;

        while(curr!=null)
        {
            int i=1,j=1;

            while(i<M)
            {
                curr=curr.next;
                i++;
            }
            if(curr==null) return head;
            Node<Integer> temp=curr.next;

            while(j<N&&temp!=null)
            {
                temp=temp.next;
                j++;
            }

            if(temp==null)
            {
                curr.next=null;
                return head;
            }

            curr.next=temp.next;
            curr=temp.next;
        }

        return head;
    }
}
