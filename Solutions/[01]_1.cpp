#include <bits/stdc++.h>

using namespace std;

int main() {
	int data[8];
	bool ascending = true;
	bool descending = true;
	
	for (int i = 0; i < 8; i++) {
		cin >> data[i];
	}
	
	for (int i = 1; i < 8; i++) {
		if (data[i] > data[i - 1]) descending = false;
		if (data[i] < data[i - 1]) ascending = false;
	}
	
	if (ascending) cout << "ascending";
	else if (descending) cout << "descending";
	else cout << "mixed";
}
