#include <stdio.h>

int A[3] = { 3, 6, 9 };
int B[3];

void func(int n, int k);
void printArray();

void func(int n, int k) { // n : index, k : data개수
	if (n==k) {
		printArray();
		return;
	}
	else {
		B[n] = A[n];
		func(n+1, k);
	}
}

void printArray() {
    int i;
    int len = sizeof(A)/sizeof(int);

    printf("A[] = ");
    i = 0;
    while(i<len) {
        printf("%d ", A[i]);
        i++;
    }
    printf("\nB[] = ");
    i = 0;
    while(i<len) {
        printf("%d ", B[i]);
        i++;
    }
    printf("\n");
}

int main() {
	func(0, 3);
}