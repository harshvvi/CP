// Problem Link : https://codeforces.com/problemset/problem/276/C
// This approach is not optimizezd as there is an efficient method to solve this problem without segment tree
// But it is just implementation for practice
// ************** Segment Tree Approach using Lazy Propagation and Memory Efficient Implementation ******************
import java.util.*;
public class LittleGirlAndMaximumSum{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        SegmentTree tree = new SegmentTree(arr.length+1);
        for(int i =0;i<q;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            tree.update(1, 1, n, l, r);
        }
        int[] freq = new int[n];
        for(int i=0;i<n;i++) freq[i] = tree.get(1, 1, n, i+1);
        Arrays.sort(freq);
        long sum = 0;
        for(int i=n-1;i>=0;i--) sum += (freq[i]*arr[i]);
        System.out.println(sum);
    }
}
class SegmentTree{
    int[] tree;
    SegmentTree(int n){
        tree = new int[4*n];
    }
    void update(int v, int curl, int curr, int l, int r){
        if(l > r) return;
        if(curl == l && curr == r) tree[v]++;
        else{
            int mid = (curl+curr)/2;
            update(v*2, curl, mid, l, Math.min(r, mid));
            update(v*2+1, mid+1, curr, Math.max(mid+1, l), r);
        }
    }
    int get(int v, int tl, int tr, int pos) {
        if (tl == tr)
            return tree[v];
        int tm = (tl + tr) / 2;
        if (pos <= tm)
            return tree[v] + get(v*2, tl, tm, pos);
        else
            return tree[v] + get(v*2+1, tm+1, tr, pos);
    }
}
/*
*************** Square Root Decomposition Approach **********************
import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int[] freq = new int[n+1];
        int bases = (int)Math.ceil(Math.sqrt(n));
        int[] sq = new int[bases+1];
        for(int i=0;i<q;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            while (l < r && l % bases != 0 && l != 0) {
                freq[l++]++;
            }
            while (l + bases - 1 <= r) {
                sq[l/bases]++;
                l += bases;
            }
            while (l <= r) {
                freq[l++]++;
            }
        }
        for(int i=0;i<=bases;i++){
            for(int j=i*bases;j<=n && j<((i*bases)+bases);j++) freq[j] += sq[i];
        }
        Arrays.sort(freq);
        long sum = 0;
        for(int i=1;i<=n;i++) sum += (freq[i] * arr[i-1]);
        System.out.println(sum);
    }
}*/
