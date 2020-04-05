#include <bits/stdc++.h>

using namespace std;

int n, m;
set<int> data;
vector<int> finding;

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		data.insert(x);
	}
	cin >> m;
	for (int i = 0; i < m; i++) {
		int x;
		cin >> x;
		finding.push_back(x);
	}
	for (auto x: finding) {
		if (data.count(x)) cout << "1\n";
		else cout << "0\n";
	}	
}
