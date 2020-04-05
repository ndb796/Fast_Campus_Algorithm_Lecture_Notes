#include <bits/stdc++.h>

using namespace std;

int n;
map<string, int> books;
vector<string> result;

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		string book;
		cin >> book;
		books[book]++;
	}

    int max_value = 0;
	for(auto it = books.begin(); it != books.end(); it++){
		max_value = max(max_value, it->second);
	}
	
	for(auto it = books.begin(); it != books.end(); it++){
		if (it->second == max_value) {
			result.push_back(it->first);
		}
	}
	
	cout << result[0];
}
