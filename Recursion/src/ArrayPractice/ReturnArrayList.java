package ArrayPractice;

import java.util.ArrayList;

public class ReturnArrayList {
//    **IMP**
//    return array list without passing the arraylist as argument
//    creating inside the function
    public static ArrayList<Integer> indexOf(int[] arr, int k, int i){
        ArrayList<Integer> list = new ArrayList<>();
        if(i==arr.length) return list;
        if(arr[i]==k) list.add(i);
        ArrayList<Integer> temp = indexOf(arr, k, i+1);
        list.addAll(temp);
        return list;
    }


    public static ArrayList<Integer> findIndex(int[] arr, int k , int i, ArrayList<Integer> list){
        if(i==arr.length) return list;
        if(arr[i]==k) list.add(i);
        return findIndex(arr, k, i+1, list);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,3,6,4,3,2};
        ArrayList<Integer> list = findIndex(arr,3,0,new ArrayList<>());
        System.out.println(list);

        ArrayList<Integer> list2 = indexOf(arr,3,0);
        System.out.println(list2);
    }
}
