#include <bits/stdc++.h>
#include <set>
using namespace std;

int main() {
  freopen("b.in", "r", stdin);
  freopen("b.out", "w", stdout);
  int a, b;
  while (~scanf("%d %d", &a, &b)) {
    if (b < 1000 || a > 9999) {
      cout << 0 << endl;
      continue;
    }
    if (a < 1000)
      a = 1000;
    if (b > 9999)
      a = 9999;
    set<int> s;
    s.insert(1634);
    s.insert(8208);
    s.insert(9474);
    int sum = 0;
    for (int i = a; i <= b; i++) {
      if (s.find(i) != s.end()) {
        sum++;
      }
    }
    cout << sum << endl;
  }
}
