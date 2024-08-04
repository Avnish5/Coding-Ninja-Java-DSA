package lecture_8_linked_list_1;

public class Length_Of_LL {

    public static int length(Node head){

        if(head==null) return 0;

        return 1+length(head.next);
    }
}
