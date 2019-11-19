#include <stdio.h>

int L[] = { 10, 20, 30 };

void func(int n, int k);

void func(int n, int k) {
	// 기본 부분
	if (n==k) {
		printf("\n"); // 완료 시 마무리 코드
		return;
	}
	// 유도 부분
	else {
		printf("%d ", L[n]); // 재귀 시 처리 코드
		func(n+1, k);
	}
}

int main() {
	func(0, 3);
}