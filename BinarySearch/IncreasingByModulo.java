// Problem Link : https://codeforces.com/contest/1169/problem/C
import java.util.*;
public class IncreasingByModulo{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int l = 0, r = m, ans = m;
        while(l <= r){
            int mid = (r-l)/2 + l;
            int flag = 0, prev = 0;
            for(int i=0;i<n;i++){
                if(arr[i] == prev) continue;
                else if(arr[i] > prev){
                    if(arr[i]+mid < m) prev = arr[i];
                    else{
                        int temp = (arr[i]+mid)%m;
                        if(temp < prev) prev = arr[i];
                    }
                }else{
                    if(prev-arr[i] > mid){
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag == 1) l = mid+1;
            else{
                ans = mid;
                r = mid-1;
            }
        }
        System.out.println(ans);
    }
}
