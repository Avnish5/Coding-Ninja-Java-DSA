/*
Problem statement
You have been given a singly linked list of integers along with two integers, 'i,' and 'j.' Swap the nodes that are present at the 'i-th' and 'j-th' positions and return the new head to the list.

Note :
1. Remember, You need to swap the nodes, not only the data.
2. Indexing starts from 0.
3. No need to print the list, it has already been taken care.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= i < M
0 <= j < M

Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3 4
Sample Output 1 :
3 4 5 6 2 1 9
 Sample Input 2 :
2
10 20 30 40 -1
1 2
70 80 90 25 65 85 90 -1
0 6
 Sample Output 2 :
10 30 20 40
90 80 90 25 65 85 70
 */
public class Assignment_Swap_2_Nodes {

    public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {

        if(i==j) return head;

        Node<Integer> currNode=head,prev=null;
        Node<Integer> firstNode=null,secondNode=null,firstNodePrev=null,secondNodePrev=null;

        int pos=0;
        while(currNode!=null)
        {
            if(pos==i)
            {
                firstNodePrev=prev;
                firstNode=currNode;
            }
            else if(pos==j)
            {
                secondNodePrev=prev;
                secondNode=currNode;
            }

            prev=currNode;
            currNode=currNode.next;
            pos++;
        }

        if(firstNodePrev!=null)
        {
            firstNodePrev.next=secondNode;

        }
        else{
            head=secondNode;
        }

        if(secondNodePrev!=null)
        {
            secondNodePrev.next=firstNode;
        }
        else{
            head=firstNode;
        }

        Node<Integer> temp=secondNode.next;
        secondNode.next=firstNode.next;
        firstNode.next=temp;

        return head;

    }
}
/*
My code
public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
        if(head==null||i==0&&j==0)
        {
            return head;
        }

        if(j==0)
        {
            int temp=i;
            i=j;
            j=temp;
        }

        Node<Integer> p1=null,c1=null,p2=null,c2=null,curr=head,ih=head;

        int c=0;

        while(c<i)
        {
            c++;
            c1=curr.next;
            p1=curr;
            curr=c1;
        }
        c=0;
        curr=head;
        while(c<j)
        {
            c++;
            c2=curr.next;
            p2=curr;
            curr=c2;
        }
        curr=head;

        if(i==0&&Math.abs(i-j)==1)
        {
            curr.next=c2.next;
            c2.next=ih;
            return c2;
        }

        else if(Math.abs(i-j)==1)
        {
            c1.next=c2.next;
            c2.next=c1;
            p1.next=c2;
        }
        else  if(i==0&&Math.abs(i-j)>1)
        {
            Node<Integer> temp=curr.next;
            p2.next=curr;
            curr.next=c2.next;
            c2.next=temp;
            return c2;
        }
        else {

            Node<Integer> tempa=p1.next.next;
            Node<Integer> tempb=p2.next.next;

            p1.next=c2;
            c2.next=tempa;

            p2.next=c1;
            c1.next=tempb;

        }


        return ih;
    }
 */