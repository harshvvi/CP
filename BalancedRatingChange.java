// Problem Link : https://codeforces.com/problemset/problem/1237/A
import java.util.*;
public class BalancedRatingChange{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int inc = 1;
        for(int i=0;i<n;i++){
            if(arr[i]%2 == 0) arr[i] >>= 1;
            else{
                if(inc == 1){
                    arr[i] = (int)Math.ceil((double)arr[i]/2);
                    inc = 0;
                }else{
                    arr[i] = (int)Math.floor((double)arr[i]/2);
                    inc = 1;
                }
            }
            System.out.println(arr[i]);
        }
    }
}
