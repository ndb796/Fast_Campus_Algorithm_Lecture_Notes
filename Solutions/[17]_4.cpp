#include <bits/stdc++.h>

using namespace std;

int n, m, result, cnt;
vector<int> cranes;
vector<int> boxes;

int positions[50]; // 각 크레인이 현재 옮겨야 하는 박스의 번호 (0부터 시작) 
bool checked[10000]; // 각 박스를 옮겼는지의 여부 

int main(void) {
	cin >> n;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		cranes.push_back(x);
	}
	
	cin >> m;
	for (int i = 0; i < m; i++) {
		int x;
		cin >> x;
		boxes.push_back(x);
	}
	
	// 최적의 해를 구해야 하므로, 내림차순 정렬 
	sort(cranes.begin(), cranes.end(), greater<int>());
	sort(boxes.begin(), boxes.end(), greater<int>());
	
	// 모든 박스를 옮길 수 없는 경우
	if (cranes[0] < boxes[0]) {
		cout << -1;
		return 0;
	} 
	
	while (true) {
		if (cnt == m) break;
		// 모든 크레인에 대하여 각각 처리 
		for (int i = 0; i < n; i++) {
			while (positions[i] < m) {
				// 아직 안 옮긴 박스 중에서, 옮길 수 있는 박스를 만날 때까지 반복
				if (!checked[positions[i]] && cranes[i] >= boxes[positions[i]]) {
					checked[positions[i]] = true;
					positions[i] += 1;
					cnt += 1;
					break;
				}
				positions[i] += 1;
			}
		}
		result += 1;
	}
	
	cout << result;
}
