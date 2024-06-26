// Problem Link : https://codeforces.com/problemset/problem/1981/B
import java.util.*;
public class TurtleAndAnInfinteSequence{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(m == 0) System.out.println(n);
            else{
                long op = 0;
                long l = Math.max(0, n-m), r = n+m;
                long x = 1;
                for(int i=0;i<32;i++){
                    long a = x - (l%x);
                    if((l & x) > 0 || (r-l) >= a) op += x;
                    x <<= 1;
                }
                System.out.println(op);
            }
        }
    }
}
