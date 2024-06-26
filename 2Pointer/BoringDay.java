// https://codeforces.com/contest/1982/problem/C
import java.util.*;
public class BoringDay{
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long l = sc.nextLong();
            long r = sc.nextLong();
            long[] cards = new long[n];
            for (int i = 0; i < n; i++) {
                cards[i] = sc.nextLong();
            }
            int count = 0;
            long curSum = 0;
            int start = 0;
            for(int i=0;i<n;i++){
                curSum += cards[i];
                if(curSum >= l && curSum <= r){
                    count++;
                    curSum = 0;
                    start = i+1;
                }else if(curSum > r){
                    while(start <= i && curSum > r){
                        curSum -= cards[start];
                        start++;
                    }
                    if(curSum >= l && curSum <= r){
                        count++;
                        curSum = 0;
                        start = i+1;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
