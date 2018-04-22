#include <bits/stdc++.h>

using namespace std;
int main() {
  // ifstream cin("b.in");
  ofstream cout("b.in");
  int T = 100000000;
  srand((unsigned)time(NULL)); //随机数种子
  for (int i = 1; i <= T; i++) {
    cout << rand() % 10000000 << " " << rand() % 10000000 << endl;
  }
  return 0;
}