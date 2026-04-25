import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    private ArrayList<T> list;

    public Heap(){
        list = new ArrayList<>();
    }

    public void swap(int i, int j){
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private int parent(int i){ return (i-1)/2; }
    private int leftChild(int i){ return (i*2)+1; }
    private int rightChild(int i){ return (i*2)+2; }

    public void insert(T value){
        list.add(value);
        upHeap(list.size()-1);
    }

    private void upHeap(int index){
        if(index==0) return ;
        int p = parent(index);
        if(list.get(index).compareTo(list.get(p))<0){
            swap(index, p);
            upHeap(p);
        }

    }

    public T remove() throws Exception{
        if(list.isEmpty()) throw new Exception("Heap is Empty");

        T temp = list.get(0);
        T last = list.remove(list.size() - 1);
        if(!list.isEmpty()){
            list.set(0, last);
            downHeap(0);
        }
        return temp;
    }
    private void downHeap(int index){
        int min = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0){
            min = right;
        }

        if(min!=index){
            swap(min, index);
            downHeap(min);
        }

    }

    public T peek() {
        if(list.isEmpty()) throw new RuntimeException("Empty");
        return list.get(0);
    }

    public ArrayList<T>  heapSort() throws Exception{
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()){
            data.add(this.remove());
        }
        return data;
    }




}
