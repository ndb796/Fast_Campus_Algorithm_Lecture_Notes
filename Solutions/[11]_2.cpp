#include <bits/stdc++.h>

using namespace std;

int n, result;
// C++에서는 기본적으로 우선순위 큐가 최대 힙(Max Heap)
priority_queue<int> pq;

int main(void) {
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		pq.push(-x);
	}
	
	while (pq.size() != 1) {
		int one = pq.top();
		pq.pop();
		int two = pq.top();
		pq.pop();
		int sum_value = one + two;
		result += sum_value;
		pq.push(sum_value);
	}
	
	cout << -result;
}
