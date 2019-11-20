#include <stdio.h>

int L[3];

void func(int n, int k) { // n : index, k : 방의 개수
	if (n==k) {
		for (int i = 0; i < k; i++)
			printf("%d ", L[i]);
		printf("\n");
	}
	else {
		L[n] = 0;
		func(n+1, k);
		L[n] = 1;
		func(n+1, k);
	}
}

int main() {
	func(0, 3);
}