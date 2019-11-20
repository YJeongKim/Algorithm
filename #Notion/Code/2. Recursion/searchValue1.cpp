#include <stdio.h>

int L[] = { 1, 5, 9 };

void func(int n, int k, int v) { // n : index, k : data개수, v : 찾는 data
	// 종료조건 : 값을 찾지 못한 경우
	if (n==k) {
		printf("검색실패\n");
		return;
	}
	// 결과충족 : 값을 찾은 경우
	else if (L[n]==v) {
		printf("%d\n", n);
		return;
	}
	else {
		func(n+1, k, v);
	}
}

int main() {
	func(0, 3, 5);
}