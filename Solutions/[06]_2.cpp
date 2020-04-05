#include <bits/stdc++.h>

using namespace std;

int result;
int N, X, Y;

void solve(int n, int x, int y) {
	if (n == 2) {
		if (x == X && y == Y) {
			cout << result;
			return;
		}
		result++;
		if (x == X && y + 1 == Y) {
			cout << result;
			return;
		}
		result++;
		if (x + 1 == X && y == Y) {
			cout << result;
			return;
		}
		result++;
		if (x + 1 == X && y + 1 == Y) {
			cout << result;
			return;
		}
		result++;
		return;
	}
	solve(n / 2, x, y);
	solve(n / 2, x, y + n / 2);
	solve(n / 2, x + n / 2, y);
	solve(n / 2, x + n / 2, y + n / 2);
}

int main() {
	cin >> N >> X >> Y;
	solve(pow(2, N), 0, 0);
}
