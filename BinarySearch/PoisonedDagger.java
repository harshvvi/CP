// Problem Link : https://codeforces.com/problemset/problem/1613/C
import java.util.*;
public class PoisonedDagger{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long h = sc.nextLong();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            long l = 0, r = h, ans = h;
            outer:while(l <= r){
                long mid = (r-l)/2 + l;
                long cur = mid;
                for(int i=1;i<n;i++){
                    long temp = arr[i] - arr[i-1];
                    if(cur >= h){
                        ans = mid;
                        r = mid-1;
                        continue outer;
                    }
                    if(temp <= mid) cur += temp;
                    else cur += mid;
                }
                if(cur >= h){
                    ans = mid;
                    r = mid-1;
                }else l = mid+1;
            }
            System.out.println(ans);
        }
    }
}
