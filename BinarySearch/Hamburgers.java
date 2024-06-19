// Problem Link : https://codeforces.com/contest/371/problem/C
import java.util.*;
public class Hamburgers{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String san = sc.nextLine();
        int[] req = new int[3];
        int[] n = new int[3];
        int[] p = new int[3];
        for(int i=0;i<san.length();i++){
            if(san.charAt(i) == 'B') req[0]++;
            else if(san.charAt(i) == 'S') req[1]++;
            else req[2]++;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            n[i] = sc.nextInt();
            min = Math.min(min, (int)Math.floor((double)n[i]/req[i]));
        }
        for(int i=0;i<3;i++){
            n[i] -= (min*req[i]);
        }
        for(int i=0;i<3;i++) p[i] = sc.nextInt();
        long rub = sc.nextLong();
        long ans = 0;
        long l = 0, r = (long)1e12;
        outer:while(l <= r){
            long mid = (l+r)/2;
            long x = 0;
            for(int i=0;i<3;i++){
                long y = Math.max(0, (mid*req[i])-n[i]);
                x += (y*p[i]);
                if(x > rub){
                    r = mid-1;
                    continue outer;
                }
            }
            ans = mid;
            l = mid+1;
        }
        System.out.println(ans+min);
    }
}
