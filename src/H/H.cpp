#include <bits/stdc++.h>
using namespace std;
const int MAXN = 105;
const int INF = 99999;
int n,q;
int a[MAXN][MAXN];
int dis[MAXN],vis[MAXN];
int sum = 0;

void Prim(){
    for(int i = 1; i <= n; i++){
        dis[i] = a[1][i];
        vis[i] = 0;
    }
    dis[1] = 0;
    vis[1] = 1;
    int count = 1;
    while(count < n){
        int min = INF;
        int index = 1;
        for(int i = 1; i <= n; i++){
            if(vis[i] == 0 && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        vis[index] = 1;
        count ++;
        sum += dis[index];
        for(int i = 1; i <= n; i++){
            if(vis[i] == 0 && dis[i] > a[index][i]){
                dis[i] = a[index][i];
            }
        }
    }
}
int main(){
    ifstream cin("h2.in");
    ofstream cout("h2.out");
    while(cin>>n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                cin>>a[i][j];
            }
        }
        cin>>q; 
        for(int i = 1; i <= q; i++){
            int u, v;
            cin>>u>>v;
            a[u][v] = a[v][u] = 0;
        }
        sum = 0;
        //Kruskal();
        Prim();
        cout<<sum<<endl;
    }
    return 0;
}
