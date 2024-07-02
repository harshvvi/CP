// Problem Link : https://codeforces.com/problemset/problem/166/E
import java.util.*;
public class Tetrahedron{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1) System.out.println("0");
        else if(n == 2) System.out.println("3");
        else if(n == 3) System.out.println("6");
        else{
            int mod = 1000000007;
            long[] arr = new long[n+1];
            long[] brr = new long[n+1];
            brr[2] = 2;
            brr[3] = 7;
            arr[2] = 3;
            arr[3] = 6;
            for(int i=4;i<=n;i++){
                brr[i] = (brr[i-1]<<1) + arr[i-1];
                brr[i] %= mod;
                arr[i] = (brr[i-2]*6) + (arr[i-2]*3);
                arr[i] %= mod;
            }
            System.out.println(arr[n]);
        }
    }
}
