#include <bits/stdc++.h>

using namespace std;

string document, word;
int idx, result;

int main() {
	getline(cin, document);
	getline(cin, word);
	while (document.length() - idx >= word.length()) {
		if (document.substr(idx, word.length()) == word) {
			result += 1;
			idx += word.length();
		}
		else {
			idx++;
		}
	}
	cout << result;
}
