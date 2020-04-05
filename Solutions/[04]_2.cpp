#include <bits/stdc++.h>

using namespace std;

string n;

int main() {
	cin >> n;
	for (int i = 9; i >= 0; i--) {
		for (char x: n) {
			if (x - '0' == i) {
				cout << i;
			}
		}
	}
}
