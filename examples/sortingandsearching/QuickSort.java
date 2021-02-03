import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int a[],int start,int end)
    {
        int partition = partition(a,start,end);
        if(partition - 1 > start)
            quickSort(a,start,partition-1);
        if(partition+1<end)
            quickSort(a,partition+1,end);
    }
    private static int partition(int a[], int start, int end)
    {
        int pivot = a[end];
        for(int i = start;i<end;i++)
        {
            if(a[i]<pivot)
            {
                swap(a,start,i);
                start++;
            }
        }
        swap(a,start,end);
        return start;

    }
   private static void swap(int a[],int index1,int index2)
    {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
   
    public static void main(String[] args) {
       
        int a[] ={5,34,1,2,7,8,23,5,9,3,5,7,8};
        long startTime = System.currentTimeMillis();
        quickSort(a, 0, a.length-1);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(a));
        System.out.println("Time for quic Sort is : "+(endTime-startTime));
       
    }
}
