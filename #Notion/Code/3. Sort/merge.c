#include <stdio.h>

int array[10] = {1, 10, 6, 4, 8, 2, 9, 3, 7, 5};
int sorted[10];

void printArray(int data[], int n) {
    int i;

    for (i = 0; i < n; i++)
        printf("%d ", data[i]);
    printf("\n");
}

void merge(int data[], int m, int middle, int n) {
    int i = m;
    int j = middle + 1;
    int k = m;

    while (i <= middle && j <= n) {
        if (data[i] <= data[j]) {
            sorted[k] = data[i];
            i++;
        } else {
            sorted[k] = data[j];
            j++;
        }
        k++;
    }

    if (i > middle) {
        for (int t = j; t <= n; t++) {
            sorted[k] = data[t];
            k++;
        }
    } else {
        for (int t = i; t <= middle; t++) {
            sorted[k] = data[t];
            k++;
        }
    }

    for (int t = m; t <= n; t++) {
        data[t] = sorted[t];
    }
}

void mergeSort(int data[], int m, int n) {
    if (m < n) {
        int middle = (m + n) / 2;
        mergeSort(data, m, middle);
        mergeSort(data, middle + 1, n);
        merge(data, m, middle, n);
    }
}

int main(void) {
    int n = sizeof(array) / sizeof(array[0]);

    printArray(array, n);
    mergeSort(array, 0, n-1);
    printArray(array, n);

    return 0;
}