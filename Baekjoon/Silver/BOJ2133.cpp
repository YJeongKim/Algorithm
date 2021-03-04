#include <iostream>

using namespace std;

/* 문제: 타일 채우기 / 분류: 다이나믹 프로그래밍 */
int dp[31];

int tiling(int n) {
    if (n == 0) return 1;
    if (n == 1) return 0;
    if (n == 2) return 3;
    if (dp[n] != 0) return dp[n];
    int result = 3 * tiling(n - 2);
    for (int i = 3; i <= n; i++) {
        if (i % 2 != 0) continue;
        result += 2 * tiling(n - i);
    }
    return dp[n] = result;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    cin >> n;
    cout << tiling(n);
    return 0;
}