import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(12);
        heap.insert(15);
        heap.insert(18);
        heap.insert(1);
        heap.insert(7);

        System.out.println(heap.remove());

        ArrayList<Integer> list = heap.heapSort();
        System.out.println(list);

    }
}