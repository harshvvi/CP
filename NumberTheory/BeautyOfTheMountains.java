// Problem Link : https://codeforces.com/contest/1982/problem/D
import java.util.*;
public class BeautyOfTheMountains{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++) arr[i][j] = sc.nextInt();
            }
            int[][] mat = new int[n][m];
            int[][] prefix = new int[n][m];
            long diff = 0;
            for(int i=0;i<n;i++){
                String temp = sc.next();
                for(int j=0;j<m;j++){
                    if(temp.charAt(j) == '0'){
                        mat[i][j] = 0;
                        diff += arr[i][j];
                    }
                    else{
                        mat[i][j] = 1;
                        diff -= arr[i][j];
                    }
                }
            }
            if(diff == 0){
                System.out.println("YES");
                continue;
            }
            prefix[0][0] = mat[0][0];
            for(int i=1;i<m;i++) prefix[0][i] = prefix[0][i-1] + mat[0][i];
            for(int i=1;i<n;i++) prefix[i][0] = prefix[i-1][0] + mat[i][0];
            for(int i=1;i<n;i++){
                for(int j=1;j<m;j++){
                    prefix[i][j] = prefix[i][j-1] + prefix[i-1][j] - prefix[i-1][j-1] + mat[i][j];
                }
            }
            int g = 0;
            for(int i=0;i<n-k+1;i++){
                for(int j=0;j<m-k+1;j++){
                    int temp = prefix[i+k-1][j+k-1];
                    if(j > 0) temp -= prefix[i+k-1][j-1];
                    if(i > 0) temp -= prefix[i-1][j+k-1];
                    if(i > 0 && j > 0) temp += prefix[i-1][j-1];
                    temp = (int)Math.abs(k*k - 2*temp);
                    g = gcd(temp, g);
                }
            }
            if(g == 0 || diff % g != 0)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
