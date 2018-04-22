#include <iostream>
#include <cmath>
using namespace std;
bool reverse(string a, string b) {
  for (int i = 0; i < a.size(); i++) {
    int d = abs(a[i] - b[b.size() - 1 - i]);
    if (d != 0 && d != 32)
      return 0;
  }
  return 1;
}
bool relate(string a, string b) {
  for (int i = 0; i < a.size(); i++) {
    int d = abs(a[i] - b[i]);
    if (d != 0 && d != 32)
      return 0;
  }
  return 1;
}
int main() {
  string a, b;
  cin >> a >> b;
  if (a.size() != b.size()) {
    cout << 1 << endl;
  } else if (a == b) {
    cout << 2 << endl;
  } else if (relate(a, b)) {
    cout << 3 << endl;
  } else if (reverse(a, b)) {
    cout << 4 << endl;
  } else
    cout << 5 << endl;
  return 0;
}