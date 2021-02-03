public class BinarySearch {
    public static boolean binarySearchIterative(int arr[],int se)
    {
            int left = 0;
            int right = arr.length - 1;
            while(left<=right)
            {
                int mid = (left+right)/2;
                if(arr[mid] == se)
                    return true;
                else if(se>arr[mid])
                    left = mid+1;
                else 
                    right = mid-1;
            }
            return false;
    }

    public static boolean binarySearchRecursive(int arr[],int se,int left,int right)
    {
        if(left>right)
            return false;
        int mid = (left+right)/2;
        if(arr[mid] == se)
            return true;
        else if(se > arr[mid])
            return binarySearchRecursive(arr, se,mid+1,right);
        else 
            return binarySearchRecursive(arr, se,left,mid-1);
    }

    public static void main(String[] args) {
        int a[] = {10,20,30,40,50,60,70,80,90,100};
        int se = 12;
        System.out.println("The element is present in the array: "+binarySearchIterative(a, se));
        System.out.println("The element found using recursion : "+binarySearchRecursive(a, se, 0, a.length-1));
    }
}
