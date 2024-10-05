import java.util.Arrays;

public class Main {

    public static void merge(int[] arr,int s1,int e1,int s2,int e2)
    {

        int[] output = new int[e2 - s1 + 1];

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
            else {
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
        int t=0;
        for (int l = 0; l < output.length; l++) {
            arr[s1 + l] = output[l];
        }

    }
    public static void mergeSort(int[] arr,int s,int e)
    {
        if(s>=e) return;
        int mid=(s+e)/2;
        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1,e);
        merge(arr,s,mid,mid+1,e);
    }
    public static void main(String[] args) {

        int[] arr={5,1,3,-7,2};
        int e=arr.length-1;
       mergeSort(arr,0,e);
        System.out.println(Arrays.toString(arr));

    }
}