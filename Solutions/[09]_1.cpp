#include <bits/stdc++.h>

using namespace std;

int n, c;
vector<int> data;

int main() {
	cin >> n >> c;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		data.push_back(x);
	}
	
	sort(data.begin(), data.end());

	int start = data[1] - data[0];
	int end = data[n - 1] - data[0];
	int result = 0;
	
	while (start <= end) {
		int mid = (start + end) / 2; 
		int value = data[0];
		int cnt = 1;
		for (int i = 1; i < n; i++) {
			if (data[i] >= value + mid) {
				value = data[i];
				cnt += 1;
			}
		}
		if (cnt >= c) { 
			start = mid + 1;
			result = mid;
		}
		else {
			end = mid - 1;
		}
	}
	
	cout << result;
}
