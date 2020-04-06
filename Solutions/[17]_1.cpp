#include <bits/stdc++.h>

using namespace std;

int data[6] = {500, 100, 50, 10, 5, 1};
int changes, result;

int main(void) {
	cin >> changes;
	changes = 1000 - changes;
	for (int i = 0; i < 6; i++) {
		result += changes / data[i];
		changes %= data[i];
	}
	cout << result;
}
