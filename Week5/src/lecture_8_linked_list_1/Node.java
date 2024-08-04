package lecture_8_linked_list_1;

public class Node<T> {

    T data;
    Node<T> next;

    Node(T data)
    {
        this.data=data;
        this.next=null;
    }
}
