#include <bits/stdc++.h>

using namespace std;

int n, s, m;
vector<int> data;
int dp[101][1001];

int main() {
	cin >> n >> s >> m;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		data.push_back(x);
	}
	
	dp[0][s] = 1;
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= m; j++) {
			if (dp[i - 1][j] == 0) continue;
			if (j - data[i - 1] >= 0) {
				dp[i][j - data[i - 1]] = 1;
			}
			if (j + data[i - 1] <= m) {
				dp[i][j + data[i - 1]] = 1;
			}
		}
	}
	
	int result = -1;
	for (int i = m; i >= 0; i--) {
		if (dp[n][i] == 1) {
			result = i;
			break;
		}
	}
	
	cout << result;
}
