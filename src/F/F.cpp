#include <bits/stdc++.h>
using namespace std;

struct ID {
 public:
  string a;
  string b;
  friend bool operator<(ID first, ID that) {
    if (first.b != that.b)
      return first.b > that.b;
    else
      return first.a > that.a;
  }

} ids[100001];

int main(int argc, char const *argv[]) {
  ifstream cin("f2.in");
  ofstream cout("f2.out");
  int T;
  cin >> T;
  for (int i = 0; i < T; i++) {
    cin >> ids[i].a;
    ids[i].b = ids[i].a.substr(6, 8);
  }
  sort(ids, ids + T);
  for (int i = 0; i < T; i++) {
    cout << ids[i].a << endl;
  }
  return 0;
}
