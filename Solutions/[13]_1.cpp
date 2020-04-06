#include <bits/stdc++.h>

using namespace std;

string x, y;
int dp[1001][1001];

int main() {
	cin >> x >> y;
	
	for (int i = 1; i <= x.length(); i++) {
		for (int j = 1; j <= y.length(); j++) {
			if (x[i - 1] == y[j - 1]) {
				dp[i][j] = dp[i - 1][j - 1] + 1;
			}
			else {
				dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
	}
	
	cout << dp[x.length()][y.length()];
}
