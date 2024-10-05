package lecture_4_recursion_2;

public class Merge_Sort {

    public static void merge(int[] arr,int s1,int e1,int s2,int e2)
    {
        int[] output=new int[e2-s1+1];
        int k=0;
        int i=s1;
        int j=s2;

        while(i<=e1&&j<=e2)
        {
            if(arr[i]>arr[j])
            {
                output[k]=arr[j];
                j++;
                k++;
            }
            else{
                output[k]=arr[i];
                i++;
                k++;
            }
        }

        while(i<=e1)
        {
            output[k]=arr[i];
            i++;
            k++;
        }

        while(j<=e2)
        {
            output[k]=arr[j];
            j++;
            k++;
        }

        for(int l=0;l<output.length;l++)
        {
            arr[s1+l]=output[l];
        }

    }

    public static void mergeSort(int[] arr, int l, int r){
        if(l>=r) return;

        int mid=(l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid,mid+1,r);

    }
}
