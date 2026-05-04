public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1,3,5,6,7,8,12,14,15,19,21};
        int target = 200;
        int s = 0;
        int e = arr.length-1;
        int ans = -1;
        while(s<=e){
            int mid = (s+e)/2;
            if(arr[mid]==target){
                ans = mid;
                break;
            }
            else if(arr[mid]>target) e = mid-1;
            else s = mid+1;
        }
        if(ans!=-1) System.out.println(target+ " Found at index " + ans);
        else System.out.println("Not found");
    }
}
