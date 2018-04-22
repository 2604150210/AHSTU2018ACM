#include <bits/stdc++.h>
using namespace std;
int main() {
  ifstream cin("c.in");
  ofstream cout("c.out");
  char buffer[1000];
  int T;
  cin >> T;
  while (T--) {
    cin >> buffer;
    int n = strlen(buffer);
    sort(buffer, buffer + n);
    cout << (buffer[0] == buffer[n - 1] ? "Y" : "N") << endl;
  }
}
