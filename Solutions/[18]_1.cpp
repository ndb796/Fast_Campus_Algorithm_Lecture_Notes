#include <bits/stdc++.h>

using namespace std;

int n, k, result;
vector<int> data;
vector<int> distances;

int main(void) {
	cin >> n >> k;
	
	// 집중국의 개수가 n 이상일 때
	if (k >= n) {
		cout << 0; // 각 센서의 위치에 설치하면 되므로 정답은 0 
		return 0;
	}
	
	// 모든 센서의 위치를 입력 받아 오름차순 정렬
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		data.push_back(x);
	}
	sort(data.begin(), data.end());
	
	// 각 센서 간의 거리를 계산하며 기록 
	for (int i = 1; i < n; i++) {
		distances.push_back(data[i] - data[i - 1]);
		result += data[i] - data[i - 1];
	}
	
	// 내림차순 정렬 
	sort(distances.begin(), distances.end(), greater<int>());
	
	// 가장 긴 거리부터 하나씩 제거
	for (int i = 0; i < k - 1; i++) {
		result -= distances[i];
	}
	
	cout << result;
}
