#include <bits/stdc++.h>

using namespace std;

int n, m, start, finish;
vector<pair<int, int> > adj[500];
int d[500];
vector<pair<int, int> > reverseAdj[500];
bool dropped[500][500];

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
			if (d[next] > nextDist && !dropped[now][next]) {
				d[next] = nextDist;
				pq.push(make_pair(-nextDist, next));
			}
		}
	}
}

void bfs() {
	queue<int> q;
	q.push(finish);
	while (!q.empty()) {
		int now = q.front();
		q.pop();
		if (now == start) continue;
		for (int i = 0; i < reverseAdj[now].size(); i++) {
			int prev = reverseAdj[now][i].first;
			int cost = reverseAdj[now][i].second;
			// 최단 경로에 포함된 경우 체크하기 
			if (d[now] == d[prev] + cost) {
				dropped[prev][now] = true;
				q.push(prev);
			}
		}
	}
}

int main() {
	while (true) {
		cin >> n >> m;
		if (n == 0) break;
		cin >> start >> finish;
		for (int i = 0; i < n; i++) {
			adj[i].clear();
			reverseAdj[i].clear();
		}
		for (int i = 0; i < m; i++) {
			int x, y, cost;
			cin >> x >> y >> cost;
			adj[x].push_back(make_pair(y, cost));
			reverseAdj[y].push_back(make_pair(x, cost));
		}
		// false로 초기화할 때는 memset() 함수 이용 
		memset(dropped, false, sizeof(dropped));
		// 특정한 값으로 초기화할 때는 fill() 함수 이용 
		fill(d, d + 500, 1e9);
		dijkstra();
		bfs();
		fill(d, d + 500, 1e9);
		dijkstra();
		if (d[finish] != 1e9) {
			cout << d[finish] << '\n';
		}
		else {
			cout << -1 << '\n';
		}
	}
}
