#include <bits/stdc++.h>

using namespace std;

string data;
int count0 = 0; // 전부 0으로 바꾸는 경우 
int count1 = 0; // 전부 1로 바꾸는 경우 

int main(void) {
	cin >> data;
	if (data[0] == '1') count0 += 1;
	else count1 += 1;
	
	for (int i = 0; i < data.length() - 1; i++) {
		if (data[i] != data[i + 1]) {
			// 다음 수에서 1로 바뀌는 경우 
			if (data[i + 1] == '1') count0 += 1;
			else count1 += 1;
		}
	}
	cout << min(count0, count1);
}
