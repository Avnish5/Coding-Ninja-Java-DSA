package lecture_18_priority_queue_1;

import java.util.ArrayList;

public class Priority_Queue_Min {

    private ArrayList<Integer> heap;

    public Priority_Queue_Min()
    {
        heap=new ArrayList<>();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int size() {
        return heap.size();
    }

    int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            // Throw an exception
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    int removeMin() throws PriorityQueueException {
        if (isEmpty()) {
            // Throw an exception
            throw new PriorityQueueException();
        }

        int remove=heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int index=0;
        int minIndex=index;
        int leftIndex=1;
        int rightIndex=2;

        while(leftIndex<heap.size())
        {
            if(heap.get(leftIndex)<heap.get(minIndex))
            {
                minIndex=leftIndex;
            }

            if(rightIndex<heap.size() && heap.get(rightIndex)<heap.get(minIndex))
            {
                minIndex=rightIndex;
            }

            if(minIndex==index)
            {
                break;
            }
            else{
                int temp=heap.get(index);
                heap.set(index, heap.get(minIndex));
                heap.set(minIndex,temp);

                index=minIndex;
                leftIndex=2*index+1;
                rightIndex=2*index+2;
            }
        }

        return remove;
    }

}
