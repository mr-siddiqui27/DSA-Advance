public class SqrtOFANumber {

    public static int sqrtOf(int n){
        int st = 0;
        int end = n;
        int mid;
        int ans = -1; // store floor value of sqrt
        while(st <= end){
            mid = st + (end - st) / 2;
            if(mid * mid == n) {
                return mid;  // exact square root found
            } else if(mid * mid > n) {
                end = mid - 1;
            } else {
                ans = mid;   // mid*mid < n, store as possible answer
                st = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sqrtOf(24)); // Output: 4
        System.out.println(sqrtOf(25)); // Output: 5
        System.out.println(sqrtOf(26)); // Output: 5
    }
}
