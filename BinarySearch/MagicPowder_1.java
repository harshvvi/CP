// Problem Link : https://codeforces.com/contest/670/problem/D1
import java.util.*;
public class MagicPowder_1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0;i<n;i++) a[i] = sc.nextInt();
        for(int i=0;i<n;i++) b[i] = sc.nextInt();
        int l = 0, r = (int)1e5;
        int ans = 0;
        while(l <= r){
            int mid = (l+r)/2;
            int req = 0;
            for(int i=0;i<n;i++){
                req += (((a[i]*mid) >= b[i]) ? (a[i]*mid - b[i]) : 0); 
            }
            if(req <= k){
                ans = mid;
                l = mid+1;
            }else r = mid-1;
        }
        System.out.println(ans);
    }
}
