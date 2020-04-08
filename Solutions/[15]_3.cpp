#include <bits/stdc++.h>

using namespace std;

int n, m, max_value;
vector<int> adj[10001];
bool visited[10001];
vector<int> result;

int bfs(int x) {
	queue<int> q;
	q.push(x);
	memset(visited, false, sizeof(visited));
	visited[x] = true;
	int cnt = 1;
	while (!q.empty()) {
		int now = q.front();
		q.pop();
		for (int i = 0; i < adj[now].size(); i++) {
			int y = adj[now][i];
			if (!visited[y]) {
				q.push(y);
				visited[y] = true;
				cnt++;
			}
		}
	}
	return cnt;
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		adj[y].push_back(x);
	}
	for (int i = 1; i <= n; i++) {
		int cnt = bfs(i);
		if (cnt > max_value) {
			result.clear();
			result.push_back(i);
			max_value = cnt;
		}
		else if (cnt == max_value) {
			result.push_back(i);
		}
	}
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << ' ';
	}
}
