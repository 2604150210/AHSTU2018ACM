#include <bits/stdc++.h>
using namespace std;
#define OJMODE
int main() {

#ifdef OJMODE
  ifstream cin("a.in");
  ofstream cout("a.out");
#endif

  int a, b;
  while (cin >> a >> b) {
    if (a == 0 && b == 0)
      break;
    cout << ((a + b) % 7 == 0 ? 7 : (a + b) % 7) << endl;
  }
}