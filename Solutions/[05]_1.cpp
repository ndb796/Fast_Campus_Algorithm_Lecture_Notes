#include <bits/stdc++.h>

using namespace std;

bool compare (pair<int, string> a, pair<int, string> b) {
	return a.first < b.first;
}

int n;
vector<pair<int, string>> data;

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		int x;
		string y;
		cin >> x >> y;
		data.push_back(make_pair(x, y));
	}
	stable_sort(data.begin(), data.end(), compare);
	for (auto x: data) {
		cout << x.first << " " << x.second << '\n';
	}
}
