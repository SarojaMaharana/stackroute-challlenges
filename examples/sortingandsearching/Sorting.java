public class Sorting
{
    public static void bubbleSort(int arr[])
    {
        long start = System.currentTimeMillis();
        int temp = 0;
        //phone list, number list, roll number, names --> array
        for(int i = 0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length - i - 1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("The sorted array : ");
        for(int x:arr)
        {
            System.out.print(x +" ");
        }
        long end = System.currentTimeMillis();

        System.out.println("Time taken for bubbleSort to run : "+(end-start));
    }

    public static void main(String[] args) {
        
        bubbleSort(new int[]{5,34,1,2,7,8,23,5,9,3,5,7,8});
    }
}