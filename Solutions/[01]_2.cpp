#include <bits/stdc++.h>

using namespace std;

int n, m;
int data[100];
int result = 0;
	
int main() {
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> data[i];
	}
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			for (int k = j + 1; k < n; k++) {
				int sum = data[i] + data[j] + data[k];
				if (sum <= m) result = max(result, sum);
			}
		}
	}
	cout << result;
}
