#include <iostream>
#include <cstring>
using namespace std;

int INF = 1e9;
int n;
int l[202]; 
int r[200][200][200];

int borw(int i, int w, int b) { 
    if (i == n){
        r[i][w][b] = 0;
    	return 0;
    }
    if (r[i][w][b] >= 0){
        return r[i][w][b]; 
    }
    else if (l[i] < l[b]){
        r[i][w][b] = max(borw(i+1,w,i), 1+borw(i+1,w,b));
    	return r[i][w][b];
    }
    else if (l[i] > l[w]){
        r[i][w][b] = max(borw(i+1,i,b), 1+borw(i+1,w,b));
    	return r[i][w][b];
    }
    else {
        r[i][w][b] = (1+borw(i+1,w,b));
    	return r[i][w][b];
    }
}

int main() {
    cin>>n;
    while (n != -1){
        int c;
        for (int i = 0; i<n; i++){
            cin>>c;
            l[i] = c;
        }
    l[200] = 0;
    l[201] = INF;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++){
                r[i][j][k] = -INF;
            }
        }
    }
    cout<<n-borw(0, 200, 201)<<endl;
    cin>>n;
    }
    return 0;
}

