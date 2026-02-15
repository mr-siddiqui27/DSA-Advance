public class LinearSearch {
    static int linearSearch(int[] arr, int index, int key) {
         if (index == arr.length)
            return -1;

         if (arr[index] == key)
            return index;

         return linearSearch(arr, index + 1, key);
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 9, 3};
        int key = 9;

        int result = linearSearch(arr, 0, key);

        if (result != -1)
            System.out.println("Element found at index " + result);
        else
            System.out.println("Element not found");
    }
}
