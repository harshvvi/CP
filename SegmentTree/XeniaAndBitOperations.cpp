// Problem Link : https://codeforces.com/contest/339/problem/D
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
 
class SegmentTree{
  public:
    vector<unsigned long long> list;
    
    SegmentTree(const vector<unsigned long long>& arr, int n, int total){
      list.resize(4*n);
      build(0, arr, 0, n-1, 0, total);
    }
    
    void build(int pos, const vector<unsigned long long>& arr, int l, int r, int cur, int total){
      if(l == r){
        list[pos] = arr[l];
      }
      else{
        int mid = (l+r)/2;
        build(pos*2+1, arr, l, mid, cur+1, total);
        build(pos*2+2, arr, mid+1, r, cur+1, total);
        if(total%2 == 1){
          if(cur%2 == 0) list[pos] = list[pos*2+1] | list[pos*2+2];
          else list[pos] = list[pos*2+1] ^ list[pos*2+2];
        }else{
          if(cur%2 == 1) list[pos] = list[pos*2+1] | list[pos*2+2];
          else list[pos] = list[pos*2+1] ^ list[pos*2+2];
        }
      }
    }
    
    void update(int pos, int p, int l, int r, unsigned long long val, int cur, int total){
      if(l == r) list[pos] = val;
      else{
        int mid = (l+r)/2;
        if(p <= mid){
          update(pos*2+1, p, l, mid, val, cur+1, total);
        }else{
          update(pos*2+2, p, mid+1, r, val, cur+1, total);
        }
        if(total%2 == 1){
          if(cur%2 == 0) list[pos] = list[pos*2+1] | list[pos*2+2];
          else list[pos] = list[pos*2+1] ^ list[pos*2+2];
        }else{
          if(cur%2 == 1) list[pos] = list[pos*2+1] | list[pos*2+2];
          else list[pos] = list[pos*2+1] ^ list[pos*2+2];
        }
      }
    }
};
 
int main(){
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  
  int n, m;
  cin >> n >> m;
  int total = pow(2, n);
  vector<unsigned long long> arr(total);
  for(int i=0;i<total;i++) cin >> arr[i];
  SegmentTree tree(arr, total, n);
  for(int i=0;i<m;i++){
    int p;
    unsigned long long b;
    cin >> p >> b;
    tree.update(0, p-1,  0, total-1, b, 0, n);
    cout << tree.list[0] << "\n";
  }
}
