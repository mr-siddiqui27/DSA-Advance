package ArrayPractice;

public class LinearSearch {

    static int linearSearch(int[] arr, int i, int k){
        if(i==arr.length) return -1;
        if(arr[i]==k) return i;
        return linearSearch(arr,i+1,k);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,0};
        System.out.println(linearSearch(arr,0,6));
    }
}
