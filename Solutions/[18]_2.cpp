#include <bits/stdc++.h>

using namespace std;

int n, m, result;
vector<int> data;
// C++에서는 기본적으로 우선순위 큐가 최대 힙(Max Heap)
priority_queue<int> positive, negative;
int max_value = -10001;
int min_value = 10001;

int main(void) {
	cin >> n >> m;
	
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		data.push_back(x);
		max_value = max(max_value, x);
		min_value = min(min_value, x);
	}
	
	// 가장 거리가 먼 책까지의 거리 
	int largest = max(max_value, -min_value);
	
	// 최대 힙(Max Heap)을 이용
	for (int i = 0; i < n; i++) {
		// 책의 위치가 양수인 경우
		if (data[i] > 0) positive.push(data[i]);
		else negative.push(-data[i]);
	}
	
	while (!positive.empty()) {
		// 한 번에 m개씩 옮길 수 있으므로 m개씩 빼내기
		result += positive.top();
		positive.pop();
		for (int i = 0; i < m - 1; i++) {
			if (!positive.empty()) positive.pop();
		} 
	}
	
	while (!negative.empty()) {
		// 한 번에 m개씩 옮길 수 있으므로 m개씩 빼내기
		result += negative.top();
		negative.pop();
		for (int i = 0; i < m - 1; i++) {
			if (!negative.empty()) negative.pop();
		} 
	}
	
	// 일반적으로 왕복 거리를 계산하지만, 가장 먼 곳은 편도 거리 계산
	cout << result * 2 - largest;
}
