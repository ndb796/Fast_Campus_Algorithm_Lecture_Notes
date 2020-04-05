#include <bits/stdc++.h>

using namespace std;

int tc;

int main() {
	cin >> tc;
	
	while (tc--) {
		string s;
		cin >> s;
		
		stack<char> left;
		stack<char> right;
		
		for (int i = 0; i < s.length(); i++) {
			if (s[i] == '-') {
				if (!left.empty()) left.pop();
			}
			else if (s[i] == '<') {
				if (!left.empty()) {
					right.push(left.top());
					left.pop();
				}
			}
			else if (s[i] == '>') {
				if (!right.empty()) {
					left.push(right.top());
					right.pop();
				}
			}
			else {
				left.push(s[i]);
			}
		}
		
		vector<char> result;
		while (!right.empty()) {
			left.push(right.top());
			right.pop();
		}
		while (!left.empty()) {
			result.push_back(left.top());
			left.pop();
		}
		reverse(result.begin(), result.end());
		for (auto x: result) {
			cout << x;
		}
		cout << '\n';
	}
}
