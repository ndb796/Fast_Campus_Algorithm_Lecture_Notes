#include <bits/stdc++.h>

using namespace std;

int t, m, n, k;
int data[50][50];
bool visited[50][50];
// (상, 하, 좌, 우) 4가지 방향 
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

void dfs(int x, int y) {
	visited[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
			continue;
		}
		if (data[nx][ny] && !visited[nx][ny]) {
			dfs(nx, ny);
		}
	}
}

int main() {
	cin >> t;
	while (t--) {
		cin >> m >> n >> k;
		memset(data, 0, sizeof(data));
		memset(visited, false, sizeof(visited));
		
		for (int i = 0; i < k; i++) {
			int y, x;
			cin >> y >> x;
			data[x][y] = 1;
		}
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (data[i][j] && !visited[i][j]) {
					dfs(i, j);
					result++;
				}
			}
		}
		
		cout << result << '\n';
	}
}
