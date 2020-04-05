#include <bits/stdc++.h>

using namespace std;

int tc, n, m, cnt;

int main() {
	cin >> tc;
	
	for (int i = 0; i < tc; i++) {
        queue<pair<int, int>> q;
        priority_queue<int> pq; // 높은 중요도부터 처리
        cnt = 0;
		cin >> n >> m;
		
        for (int j = 0; j < n; j++) {
        	int x;
        	cin >> x;
        	q.push({x, j}); // {중요도, 인덱스} 삽입 
        	pq.push(x); // 중요도 삽입 
		}
		
		while (true) {
			int x = q.front().first;
			int index = q.front().second;
			q.pop();

            // 가장 중요도가 높은 경우 출력 
			if (x == pq.top()) {
				cnt++;
				pq.pop();
				if (index == m) {
					cout << cnt << '\n';
					break;
				}
			}
			else {
				q.push({x, index});
			}
		}
	}
}
