#include <bits/stdc++.h>

using namespace std;

int n;
vector<pair<int, int>> data;

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		int x, y;
		cin >> x >> y;
		data.push_back(make_pair(x, y));
	}
	sort(data.begin(), data.end());
	for (auto x: data) {
		cout << x.first << " " << x.second << '\n';
	}
}
