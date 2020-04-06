#include <bits/stdc++.h>

using namespace std;

int n, result;
vector<pair<int, int> > data;
priority_queue<int> pq;

int main(void) {
	cin >> n;
	
	// 문제 정보를 입력 받은 이후에, 데드라인을 기준으로 정렬 
	for (int i = 0; i < n; i++) {
		int x, y;
		cin >> x >> y;
		data.push_back(make_pair(x, y));
	}
	
	sort(data.begin(), data.end());
	
	for (int i = 0; i < n; i++) {
		int a = data[i].first;
		int b = data[i].second;
		pq.push(-b);
		// 데드라인을 초과하는 경우에는 최소 원소를 제거
		if (a < pq.size()) {
			pq.pop();
		}
	}

	while (!pq.empty()) {
		result += -pq.top();
		pq.pop();
	}
	
	cout << result;
}
