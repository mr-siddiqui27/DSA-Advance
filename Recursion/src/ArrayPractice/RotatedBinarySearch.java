package ArrayPractice;

public class RotatedBinarySearch {

    // not for duplicate element
    public static int searchInRotatedSortedArray(int[] arr, int k){
        int st = 0;
        int end = arr.length-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(arr[mid]==k) return mid;
            if(arr[st]<=arr[mid]){          //check first half
                if(k>=arr[st] && k<arr[mid])    end = mid-1;
                else st = mid+1;
            }else {
                if(k>arr[mid] && k<=arr[end])    st = mid+1;
                else    end = mid-1;
            }

        }
        return -1;
    }

    // using recursion
    public static int searchInRotatedSortedArrayUsingRecursion(int[] arr, int k, int st, int end){
        if(st>end) return -1;
        int mid = st+(end-st)/2;
        if(arr[mid]==k) return mid;
        else if(arr[st]<=arr[mid]){
            if(k>=arr[st] && k<arr[mid]) return searchInRotatedSortedArrayUsingRecursion(arr, k, st,mid-1);
            else return searchInRotatedSortedArrayUsingRecursion(arr, k, mid+1, end);
        }else{
            if(k>arr[mid] && k<=arr[end])   return searchInRotatedSortedArrayUsingRecursion(arr, k, mid+1, end);
            else return searchInRotatedSortedArrayUsingRecursion(arr, k, st, mid-1);
        }
    }
    

    public static void main(String[] args) {
        int[] arr = {5,6,8,-2,0,1,2,4};
        System.out.println(searchInRotatedSortedArrayUsingRecursion(arr,6,0,arr.length-1));
     }
}
