#include <bits/stdc++.h>

using namespace std;

int n, m, start;
vector<int> adj[1001];
bool d[1001];

// 깊이 우선 탐색(DFS) 
void dfs(int x) {
	if (d[x]) return;
	d[x] = true;
	cout << x << ' ';
	for (int i = 0; i < adj[x].size(); i++) {
		int y = adj[x][i];
		dfs(y);
	}
}

// 너비 우선 탐색(BFS) 
void bfs(int x) {
	queue<int> q;
	q.push(x);
	d[x] = true;
	while (!q.empty()) {
		int now = q.front();
		q.pop();
		cout << now << ' ';
		for (int i = 0; i < adj[now].size(); i++) {
			int y = adj[now][i];
			if (!d[y]) {
				q.push(y);
				d[y] = true;
			}
		}
	}
}

int main() {
	cin >> n >> m >> start;
	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		adj[x].push_back(y);
		adj[y].push_back(x);
	}
	for(int i = 1; i <= n; i++) {
		sort(adj[i].begin(), adj[i].end());
	}
	dfs(start);
	cout << '\n';
	memset(d, false, sizeof(d));
	bfs(start);
}
