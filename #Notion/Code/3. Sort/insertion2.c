#include <stdio.h>

int main(void) {
    int i, j, n, temp;
    int array[100];

    printf("배열 원소의 개수 입력 : ");
    scanf("%d", &n);

    printf("배열 원소 입력 : ");
    for (i = 0; i < n; i++)
        scanf("%d", &array[i]);

    for (i = 0; i < n; i++) {
        for (j = i; j > 0; j--) {
            if (array[j] < array[j - 1]) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
        for (j = 0; j <= i; j++)
            printf("%d ", array[j]);
        printf("\n");
    }

    return 0;
}