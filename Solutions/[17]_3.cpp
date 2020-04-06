#include <bits/stdc++.h>

using namespace std;

int n;
vector<int> data;

int main(void) {
	cin >> n;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		data.push_back(x);
	}
	
	// 오름차순 정렬 수행 
	sort(data.begin(), data.end());
	
	// 불만도의 합 계산
	long long result = 0;
	for (int i = 1; i <= n; i++) {
		result += abs(i - data[i - 1]);
	} 
	
	cout << result;
}
