public class LinearSearch
{
    public static int linearSearch(int a[],int searchElement)
    {
        for(int i = 0;i<a.length;i++)
        {
            if(a[i] == searchElement)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {5,6,7,8,21,3,4,9};
        int search = 8;
        int elementFound = linearSearch(arr, search);
        if(elementFound == -1)
            System.out.println("The element not in list");
        else
            System.out.println("The element was found at index : "+elementFound);
    }
}