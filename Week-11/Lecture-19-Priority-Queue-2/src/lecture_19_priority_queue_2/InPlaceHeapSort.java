package lecture_19_priority_queue_2;

public class InPlaceHeapSort {
    public static void inplaceHeapSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int childIndex = i;
            int parentIndex = (childIndex - 1) / 2;
            while (childIndex > 0) {

                if (arr[childIndex] < arr[parentIndex]) {
                    int temp = arr[childIndex];
                    arr[childIndex] = arr[parentIndex];
                    arr[parentIndex] = temp;

                    childIndex = parentIndex;
                    parentIndex = (childIndex - 1) / 2;
                } else {
                    break;
                }

            }
        }

        for(int i=arr.length-1;i>=0;i--)
        {
            int t=arr[0];
            arr[0]=arr[i];
            arr[i]=t;

            int index=0;
            int minIndex=index;
            int leftIndex=1;
            int rightIndex=2;

            while(leftIndex<i)
            {
                if(arr[leftIndex]<arr[minIndex])
                {
                    minIndex=leftIndex;
                }

                if(rightIndex<i && arr[rightIndex]<arr[minIndex])
                {
                    minIndex=rightIndex;
                }

                if(minIndex==index)
                {
                    break;
                }
                else{
                    int temp=arr[index];
                    arr[index]=arr[minIndex];
                    arr[minIndex]=temp;


                    index=minIndex;
                    leftIndex=2*index+1;
                    rightIndex=2*index+2;
                }
            }

        }
    }
}
