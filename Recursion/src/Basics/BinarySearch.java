package Basics;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6,8,10,12,14,17,21,32,34,41};
        int num = 10;
        int ind = binarySearch(nums, num, 0, nums.length);
        System.out.println(ind);
    }
    private static int binarySearch(int[] nums, int k, int left, int right){
        int mid = left + (right-left)/2;
        if(left>right) return -1;
        if(nums[mid]==k) return mid;
        if (nums[mid] < k) {
            left = mid+1;
        }else{
            right = mid-1;
        }
        return binarySearch(nums, k, left, right);
    }
}
