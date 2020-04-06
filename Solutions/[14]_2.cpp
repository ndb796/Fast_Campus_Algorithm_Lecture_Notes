#include <bits/stdc++.h>
#define MAX 100001

using namespace std;

int n, k;
int data[MAX];

// 너비 우선 탐색(BFS) 
int bfs() {
	queue<int> q;
	q.push(n);
	while (!q.empty()) {
		int now = q.front();
		q.pop();
		if (now == k) return data[now];
		int next = now - 1;
		if (0 <= next && next < MAX && !data[next]) {
			data[next] = data[now] + 1;
			q.push(next);
		}
		next = now + 1;
		if (0 <= next && next < MAX && !data[next]) {
			data[next] = data[now] + 1;
			q.push(next);
		}
		next = now * 2;
		if (0 <= next && next < MAX && !data[next]) {
			data[next] = data[now] + 1;
			q.push(next);
		}
	}
}

int main() {
	cin >> n >> k;
	cout << bfs();
}
