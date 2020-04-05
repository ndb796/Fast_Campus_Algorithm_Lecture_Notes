#include <bits/stdc++.h>

using namespace std;

int n, result, k = 1;

int main() {
	cin >> n;
	while (n != 0) {
		if (k > n) k = 1;
		n -= k;
		k += 1;
		result += 1;
	}
	cout << result;
}
