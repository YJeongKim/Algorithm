#include <stdio.h>

int array[10] = {1, 10, 6, 4, 8, 2, 9, 3, 7, 5};

void printArray(int data[], int n) {
    int i;

    for (i = 0; i < n; i++)
        printf("%d ", data[i]);
    printf("\n");
}

int main(void) {
    int i, j, min, index, temp;
    int n = sizeof(array) / sizeof(array[0]);

    printArray(array, n);

    for (i = 0; i < n-1; i++) {
        min = array[i];
        index = i;

        for (j = i; j < n; j++) {
            if (min > array[j]) {
                min = array[j];
                index = j;
            }
        }
        temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }

    printArray(array, n);

    return 0;
}