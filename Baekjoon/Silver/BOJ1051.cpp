#include <iostream>

using namespace std;

/* 문제: 숫자 정사각형 / 분류: 구현, 브루트포스 */
int solution(int n, int m, char square[50][50]) {
    int k = (n < m ? n : m);

    while (k > 0) {
        k--;
        for (int i = 0; i + k < n; i++) {
            for (int j = 0; j + k < m; j++) {
                if (square[i][j] == square[i + k][j] && square[i][j] == square[i][j + k] && square[i][j] == square[i + k][j + k]) {
                    return (++k * k);
                }
            }
        }
    }

    return 1;
}
int main() {
    int n, m;
    char square[50][50];

    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> square[i];
    }
    cout << solution(n, m, square) << endl;

    return 0;
}