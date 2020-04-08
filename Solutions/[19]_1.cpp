#include <bits/stdc++.h>

using namespace std;

int n, result;
int row[15];

// x번째 행에 놓은 Queen에 대하여 검증
bool check(int x) {
	// 이전 행에서 놓았던 모든 Queen들을 확인
	for (int i = 0; i < x; i++) {
		// 위쪽 혹은 대각선을 확인
		if (row[x] == row[i]) return false;
		if (abs(row[x] - row[i]) == x - i) return false;
	}
	return true;
}

// x번째 행에 대하여 처리
void dfs(int x) {
	if (x == n) result += 1;
	else {
		// x번째 행의 각 열에 Queen을 둔다고 가정
		for (int i = 0; i < n; i++) {
			row[x] = i;
			// 해당 위치에 Queen을 두어도 괜찮은 경우
			if (check(x)) {
				// 다음 행으로 넘어가기
				dfs(x + 1); 
			} 
		} 
	}
} 

int main() {
	cin >> n;
	dfs(0);
	cout << result;
}
