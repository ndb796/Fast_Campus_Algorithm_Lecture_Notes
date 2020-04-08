#include <bits/stdc++.h>

using namespace std;

int t, n, m, start;
vector<pair<int, int> > adj[10001];
int d[10001];

void dijkstra() {
	priority_queue<pair<int, int> > pq;
	pq.push(make_pair(0, start));
	d[start] = 0;
	while (!pq.empty()) {
		int dist = -pq.top().first; // 현재 노드까지의 비용 
		int now = pq.top().second; // 현재 노드 
		pq.pop();
		if (d[now] < dist) continue;
		for (int i = 0; i < adj[now].size(); i++) {
			int next = adj[now][i].first; // 다음 노드 
			int nextDist = dist + adj[now][i].second; // 현재 노드를 거쳐 가는 비용 
			if (d[next] > nextDist) {
				d[next] = nextDist;
				pq.push(make_pair(-nextDist, next));
			}
		}
	}
}

int main() {
	cin >> t;
	while (t--) {
		cin >> n >> m >> start;
		for (int i = 1; i <= n; i++) {
			adj[i].clear();
		}
		// 각 거리를 1e9로 초기화하기 위하여 fill() 함수 호출 
		fill(d, d + 10001, 1e9);
		for (int i = 0; i < m; i++) {
			int x, y, cost;
			cin >> x >> y >> cost;
			adj[y].push_back(make_pair(x, cost));
		}
		dijkstra();
		int cnt = 0;
		int maxDistance = 0;
		for (int i = 1; i<= n; i++) {
			if (d[i] != 1e9) {
				cnt++;
				maxDistance = max(maxDistance, d[i]);
			}
		}
		cout << cnt << ' ' << maxDistance << '\n';
	}
}
