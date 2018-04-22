#include <stdio.h>
/* int s(int n){
    return n>2?s(n-1)+s(n-2):1;
}*/
int main() {
  freopen("d.in", "r", stdin);
  freopen("d.out", "w", stdout);
  int a[41];
  a[0] = 0;
  a[1] = 1;
  a[2] = 1;
  a[3] = 2;
  for (int i = 4; i <= 40; i++) {
    a[i] = a[i - 1] + a[i - 3];
  }
  int n;
  scanf("%d", &n);
  while (n--) {
    int n;
    scanf("%d", &n);
    printf("%d\n", a[n]);
  }
  return 0;
}
