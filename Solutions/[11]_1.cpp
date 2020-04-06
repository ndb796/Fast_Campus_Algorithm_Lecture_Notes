#include <bits/stdc++.h>

using namespace std;

int n;
// C++에서는 기본적으로 우선순위 큐가 최대 힙(Max Heap)
priority_queue<int> pq;
vector<int> result;

int main(void) {
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		if (x == 0) {
			if (!pq.empty()) {
				result.push_back(-pq.top());
				pq.pop();
			}
			else {
				result.push_back(0);
			}
		}
		else {
			pq.push(-x);
		}
	}
	
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << '\n';
	}
}
