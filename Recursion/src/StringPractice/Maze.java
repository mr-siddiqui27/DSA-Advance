package StringPractice;

public class Maze {
    public static void main(String[] args) {
        System.out.println(pathCount(3,3));
    }


    public static int pathCount(int r, int c){
        if(r==1 || c==1){
            return 1;
        }
        int right = pathCount(r,c-1);
        int down = pathCount(r-1,c);
        return right+down;
    }
}
