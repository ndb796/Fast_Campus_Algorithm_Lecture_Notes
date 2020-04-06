#include <bits/stdc++.h>

using namespace std;

int n, result;
vector<int> data;
int dp[1000];

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		data.push_back(x);
	}
	for (int i = 0; i < n; i++) {
		dp[i] = 1;
		for (int j = 0; j < i; j++) {
			if (data[j] < data[i]) {
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
		result = max(result, dp[i]);
	}
	cout << result;
}
