#include <bits/stdc++.h>

using namespace std;

int n, m;
char data[50][50];
int row[50], column[50];

int main() {
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> data[i][j];
			if (data[i][j] == 'X') {
				row[i] = 1;
				column[j] = 1;
			}
		}
	}
	
	int row_count = 0;
	for (int i = 0; i < n; i++) {
		if (row[i] == 0) row_count++;
	}
	
	int column_count = 0;
	for (int j = 0; j < m; j++) {
		if (column[j] == 0) column_count++;
	}
	
	cout << max(row_count, column_count);
}
