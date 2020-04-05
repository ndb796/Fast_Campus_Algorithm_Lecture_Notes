#include <bits/stdc++.h>

using namespace std;

int n, cnt = 1;
stack<int> s;
vector<char> result;

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		// 입력 받은 데이터에 도달할 때까지 삽입 
		while (cnt <= x) {
			s.push(cnt);
			cnt += 1;
			result.push_back('+');
		}
		// 스택의 최상의 원소가 데이터와 같을 때 출력 
		if (s.top() == x) {
			s.pop();
			result.push_back('-');
		}
		else {
			cout << "NO";
			return 0;
		}
	}
	// 결과를 차례대로 출력 
	for (auto x: result) {
		cout << x << '\n';
	}
}
