// Problem Link : https://codeforces.com/contest/1987/problem/D
import java.util.*;
public class WorldIsMine{
    public static int[][] dp;
    public static int[] count;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            count = new int[n+1];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                count[arr[i]]++;
            }
            int op = n;
            dp = new int[n+1][n+1];
            for(int i=0;i<=n;i++){
                for(int j=0;j<=n;j++) dp[i][j] = -1;
            }
            for(int i=n;i>=0;i--){
                if(rec(n, i) != -2) op = i;
            }
            System.out.println(op);
        }
    }
    public static int rec(int index, int done){
        if(done < 0) return -2;
        if(index == 0){
            if(done == 0) return 0;
            else return -2;
        }
        if((~dp[index][done]) != 0) return dp[index][done];
        if(count[index] != 0) dp[index][done] = rec(index-1, done-1);
        else dp[index][done] = rec(index-1, done);
        int temp = rec(index-1, done);
        if(temp != -2 && temp+count[index] <= done){
            if(dp[index][done] == -2 || temp+count[index] < dp[index][done]){
                dp[index][done] = temp + count[index];
            }
        }
        return dp[index][done];
    }
}
// Another Solution
/* 
import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] freq = new int[n+1];
            for(int i=0;i<n;i++) freq[sc.nextInt()]++;
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=1;i<=n;i++){
                if(freq[i] != 0) list.add(freq[i]);
            }
            int size = list.size();
            int[][] dp = new int[size][size+1];
            for(int i=0;i<size;i++){
                for(int j=0;j<=size;j++) dp[i][j] = -1;
            }
            dp[0][1] = 1;
            for(int i=1;i<size;i++){
                for(int j=1;j<=size;j++){
                    dp[i][j] = -1;
                    if(dp[i-1][j-1] != -1) dp[i][j] = dp[i-1][j-1]+1;
                    if(dp[i-1][j] >= list.get(i)){
                        if(dp[i][j] == -1) dp[i][j] = dp[i-1][j]-list.get(i);
                        else dp[i][j] = Math.max(dp[i][j], dp[i-1][j]-list.get(i));
                    }
                }
            }
            int ans = 0;
            for(int i=1;i<=size;i++){
                if(dp[size-1][i] != -1){
                    ans = i;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
*/
