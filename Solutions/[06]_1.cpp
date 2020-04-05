#include <bits/stdc++.h>

using namespace std;

int n;

int main() {
	cin >> n;
	
	int a = 0;
	int b = 1;
	while (n > 0) {
		int temp = a;
		a = b;
		b = temp + b;
		n--;
	}
	
	cout << a;
}
