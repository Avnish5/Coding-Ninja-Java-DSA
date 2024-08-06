package assignment;
/*
Problem statement
You have been given a head to a singly linked list of integers. Write a function check to whether the list given is a 'Palindrome' or not.

Detailed explanation ( Input/output format, Notes, Images )
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
1
9 2 3 3 2 9 -1
Sample Output 1 :
true
Sample Input 2 :
2
0 2 3 2 5 -1
-1
Sample Output 2 :
false
true
Explanation for the Sample Input 2 :
For the first query, it is pretty intuitive that the the given list is not a palindrome, hence the output is 'false'.

 */
import lecture_8_linked_list_1.Node;

public class Palindrome {


    public Node<Integer> findMiddle(Node<Integer> head)
    {
        Node<Integer> slow=head,fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }
    public Node<Integer> reverse(Node<Integer> currNode)
    {
        Node<Integer> prev=null,next=null;

        while(currNode!=null)
        {
            next=currNode.next;
            currNode.next=prev;
            prev=currNode;
            currNode=next;
        }
        return prev;
    }

    public  boolean isPalindrome(Node<Integer> head) {
        if(head==null||head.next==null) return  false;

        Node<Integer> middle=findMiddle(head);
        System.out.println(middle.data);
        Node<Integer> rHead=reverse(middle);

        while(rHead!=null&&head!=null)
        {
            if(rHead.data!=head.data)
            {
                return false;
            }
            head=head.next;
            rHead=rHead.next;
        }
        return true;

    }
}
