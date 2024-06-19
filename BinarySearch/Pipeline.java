// Problem Link : https://codeforces.com/contest/287/problem/B
import java.util.*;
public class Pipeline{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        if(n == 1) System.out.println("0");
        else if(k >= n) System.out.println("1");
        else{
            long ans = -1;
            long l = 0, r = k;
            long temp = (k*(k+1))/2 - (k-1);
            while(l <= r){
                long mid = (l+r)/2;
                long x = ((k-mid)*(k-mid+1))/2 - (k-mid);
                if(temp-x >= n){
                    ans = mid;
                    r = mid-1;
                }else l = mid+1;
            }
            System.out.println(ans);
        }
    }
}
