// Problem Link : https://codeforces.com/contest/689/problem/C
import java.util.*;
public class MikeAndChocolateThieves{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long[] pow = new long[(int)1e6];
        for(int i=2;i<1000000;i++){
            pow[i] = (long)Math.pow(i, 3);
        }
        long l = 0, r = (long)1e18, ans = -1;
        while(l <= r){
            long mid = (r-l)/2 + l;
            long cur = 0;
            for(int i=2;i<1000000;i++){
                if(pow[i] > mid) break;
                cur += (long)Math.floor((double)mid/pow[i]);
            }
            if(cur > m) r = mid-1;
            else if(cur < m) l = mid+1;
            else{
                ans = mid;
                r = mid-1;
            }
        }
        System.out.println(ans);
    }
}
