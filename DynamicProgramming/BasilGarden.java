// Problem Link : https://codeforces.com/contest/1987/problem/C
import java.util.*;
public class BasilGarden{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            long op = 0;
            for(int i=0;i<n;i++) op = Math.max(op, arr[i]+i);
            System.out.println(op);
        }
    }
}
