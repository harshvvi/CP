// Problem Link : https://www.spoj.com/problems/KQUERY
// Java Solution was giving TLE but similar C++ solution was accepted
import java.io.*;
import java.util.*;

public class KQuery {
    public static void main(String[] args) throws IOException {
        InputReader sc = new InputReader(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        SegmentTree tree = new SegmentTree(arr, n);
        int q = sc.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            int k = sc.nextInt();
            bw.write(tree.query(0, 0, n - 1, l, r, k) + "\n");
        }
        bw.flush();
    }
}

class SegmentTree {
    int[][] tree;
    int[] sizes;

    SegmentTree(int[] arr, int n) {
        tree = new int[4 * n][];
        sizes = new int[4 * n];
        build(0, arr, 0, n - 1);
    }

    void build(int pos, int[] arr, int l, int r) {
        if (l == r) {
            tree[pos] = new int[]{arr[l]};
            sizes[pos] = 1;
        } else {
            int mid = (l + r) / 2;
            build(pos * 2 + 1, arr, l, mid);
            build(pos * 2 + 2, arr, mid + 1, r);
            merge(pos, pos * 2 + 1, pos * 2 + 2);
        }
    }

    void merge(int pos, int leftChild, int rightChild) {
        int leftSize = sizes[leftChild];
        int rightSize = sizes[rightChild];
        tree[pos] = new int[leftSize + rightSize];
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (tree[leftChild][i] < tree[rightChild][j]) {
                tree[pos][k++] = tree[leftChild][i++];
            } else {
                tree[pos][k++] = tree[rightChild][j++];
            }
        }

        while (i < leftSize) tree[pos][k++] = tree[leftChild][i++];
        while (j < rightSize) tree[pos][k++] = tree[rightChild][j++];
        sizes[pos] = leftSize + rightSize;
    }

    int query(int pos, int tl, int tr, int l, int r, int k) {
        if (l > r) return 0;
        if (l == tl && tr == r) return search(tree[pos], k);
        int tm = (tl + tr) / 2;
        return query(pos * 2 + 1, tl, tm, l, Math.min(r, tm), k)
             + query(pos * 2 + 2, tm + 1, tr, Math.max(l, tm + 1), r, k);
    }

    int search(int[] array, int k) {
        int l = 0, r = array.length - 1, ans = array.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (array[mid] > k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return array.length - ans;
    }
}

class InputReader {
    BufferedReader reader;
    StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}
