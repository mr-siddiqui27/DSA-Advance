public class FindNthRootOfANumber {
    public static int nthRootOf(int n, int m){
        int st=1;
        int end = m;
        while(st<=end){
            int mid = st+(end-st)/2;
            long pow = (long)Math.pow(mid,n);
            if(pow==m) return mid;
            if(pow>m) end = mid-1;
            else st = mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(nthRootOf(3,28));
    }
}
