#include <bits/stdc++.h>

using namespace std;

int n;
vector<int> data;

int ascending() {
	int now = data[0];
	int result = 1;
	for (int i = 1; i < data.size(); i++) {
		if (now < data[i]) {
			result += 1;
			now = data[i];
		}
	}
	return result;
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		data.push_back(x);
	}
	
	cout << ascending() << '\n';
	reverse(data.begin(), data.end());
	cout << ascending() << '\n';
}
