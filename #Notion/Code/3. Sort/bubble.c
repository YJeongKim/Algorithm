#include <stdio.h>

int array[10] = {1, 10, 6, 4, 8, 2, 9, 3, 7, 5};

void printArray(int data[], int n) {
    int i;

    for (i = 0; i < n; i++)
        printf("%d ", data[i]);
    printf("\n");
}

int main(void) {
    int i, j, temp;
    int n = sizeof(array) / sizeof(array[0]);

    printArray(array, n);

    for (i = 0; i < n; i++) {
        for (j = 0; j < n - 1 - i; j++) {
            if (array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }

    printArray(array, n);

    return 0;
}