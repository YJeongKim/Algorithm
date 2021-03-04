#include <iostream>

using namespace std;

/* 문제: 2×n 타일링 / 분류: 다이나믹 프로그래밍 */
int dp[1001];

int tiling(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    if (dp[n] != 0) return dp[n];
    return dp[n] = (tiling(n - 1) + tiling(n - 2)) % 10007;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    cin >> n;
    cout << tiling(n);
    return 0;
}