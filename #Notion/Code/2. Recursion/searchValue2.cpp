#include <stdio.h>

int L[] = { 1, 5, 9, 8, 4, 2, 3 };

int func(int n, int k, int v) { // n : index, k : 검색 범위(data개수), v : 검색할 data
	// 종료조건 : 값을 찾지 못한 경우
	if (n==k) {
		return 0;
	}
	// 결과충족 : 값을 찾은 경우
	else if (L[n]==v) {
		return 1;
	}
	else {
		return func(n+1, k, v); // ★return 필수★
	}
}

int main() {
	int result = func(0, 7, 4);
    printf("결과 : %d", result);
}