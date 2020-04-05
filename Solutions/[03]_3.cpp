#include <bits/stdc++.h>

using namespace std;

int tc;
int parent[200001];
int number[200001];
char one[21], two[21];

int findParent(int x) {
	if (x == parent[x]) return x;
	return parent[x] = findParent(parent[x]);
}

void unionParent(int x, int y) {
	x = findParent(x);
	y = findParent(y);
	
	if (x != y) {
		parent[y] = x;
		number[x] += number[y];
	}
}

int main() {
	cin >> tc;
	while(tc--) {
		map<string, int> data; // <이름(키), 값>
		int f;
		int cnt = 1;
		
		cin >> f;
		for (int i = 1; i <= 2 * f; i++) {
			parent[i] = i;
			number[i] = 1;
		}
		
		for (int i = 0; i < f; i++) {
			string x, y;
			scanf("%s %s", &one, &two); // scanf()를 이용하여 시간 줄이기 

			if (data.count(one) == 0) data[one] = cnt++;
			if (data.count(two) == 0) data[two] = cnt++;
			
			unionParent(data[one], data[two]);
			cout << number[findParent(data[one])] << '\n';
		}
	}
}
