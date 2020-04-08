#include <bits/stdc++.h>

using namespace std;

int n, m;
int parent[1001];
vector<pair<int, int> > locations;
vector<pair<double, pair<int, int> > > edges;

// 두 점 사이의 거리를 계산하는 함수 
double getDistance(pair<int, int> p1, pair<int, int> p2) {
	long long a = p1.first - p2.first;
	long long b = p1.second - p2.second;
	return sqrt((a * a) + (b * b));
}

int getParent(int a) {
	if (a == parent[a]) return a;
	return parent[a] = getParent(parent[a]);
}

void unionParent(int a, int b) {
	a = getParent(a);
	b = getParent(b);
	if (a < b) parent[b] = a;
	else parent[a] = b;
}

int compareParent(int a, int b) {
	a = getParent(a);
	b = getParent(b);
	if (a == b) return true;
	return false;
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		int x, y;
		cin >> x >> y;
		locations.push_back(make_pair(x, y));
	}
	
	// 모든 점 사이의 거리를 계산하여 간선(Edge) 리스트에 저장 
	for (int i = 0; i < n - 1; i++) {
		for (int j = i + 1; j < n; j++) {
			edges.push_back(make_pair(getDistance(locations[i], locations[j]), make_pair(i + 1, j + 1)));
		}
	}
	
	for (int i = 1; i <= n; i++) {
		parent[i] = i;
	}
	
	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		unionParent(a, b);
	}
	
	// 간선의 길이를 기준으로 오름차순 정렬 
	sort(edges.begin(), edges.end());
	
	double result = 0;
	for (int i = 0; i < edges.size(); i++) {
		double cost = edges[i].first;
		int a = edges[i].second.first;
		int b = edges[i].second.second;
		if (!compareParent(a, b)) {
			unionParent(a, b);
			result += cost;
		}
	}
	
	printf("%0.2f", result);
}
