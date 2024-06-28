// Problem Link : https://codeforces.com/contest/1989/problem/B
import java.util.*;
public class SubstringAndSubsequence{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String a = sc.next();
            String b = sc.next();
            int n = a.length(), m = b.length();
            int l = 0;
            int[] arr = new int[m];
            int[][] dp = new int[m][n];
            int max = 0;
            for(int i=0;i<n;i++){
                if(i > 0) dp[0][i] = dp[0][i-1];
                if(a.charAt(i) == b.charAt(0)) dp[0][i] = 1;
                max = Math.max(max, dp[0][i]);
            }
            for(int i=1;i<m;i++){
                for(int j=0;j<n;j++){
                    if(j == 0){
                        if(a.charAt(j) == b.charAt(i)) dp[i][j] = 1;
                        continue;
                    }
                    if(j > 0) dp[i][j] = dp[i][j-1];
                    if(a.charAt(j) == b.charAt(i)){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
            System.out.println(n+m-max);
        }
    }
}
