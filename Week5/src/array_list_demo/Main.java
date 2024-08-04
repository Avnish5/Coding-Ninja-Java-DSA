package array_list_demo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list1=new ArrayList<>(5);
        list1.add(1);
        list1.add(2);
        list1.add(3);

        for(int i=0;i<list1.size();i++)
        {
            System.out.print(list1.get(i)+" ");
        }
        System.out.println();
        //add will move other elements towards right
        list1.add(2,4);

        for(int i=0;i<list1.size();i++)
        {
            System.out.print(list1.get(i)+" ");
        }
        System.out.println();

        //remove will remove element at particular index and rearrange array
        list1.remove(3);

        for(int i=0;i<list1.size();i++)
        {
            System.out.print(list1.get(i)+" ");
        }
        System.out.println();

        //set will set the value at particular index without rearranging array order
        list1.set(1,100);

        for(int i=0;i<list1.size();i++)
        {
            System.out.print(list1.get(i)+" ");
        }

    }
}
