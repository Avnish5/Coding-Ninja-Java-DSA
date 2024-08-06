package lecture_8_linked_list_1;

public class Node<T> {

     public T data;
    public Node<T> next;

    Node(T data)
    {
        this.data=data;
        this.next=null;
    }
}
