#include <bits/stdc++.h>

using namespace std;

int n, m, result;
vector<int> adj[101];
bool visited[101];

void dfs(int x) {
	result++;
	visited[x] = true;
	for (int i = 0; i < adj[x].size(); i++) {
		int y = adj[x][i];
		if (!visited[y]) {
			dfs(y);
		}
	}
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		adj[x].push_back(y);
		adj[y].push_back(x);
	}
	dfs(1);
	cout << result - 1;
}
