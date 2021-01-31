#include <iostream>
#include <vector>

using namespace std;

/* 문제: 소수 찾기 / 분류: 연습문제 */
int solution(int n) {
    int answer = 0;
    vector<bool> visit(n, false);

    for (int i = 2; i <= n; i++) {
        if (!visit[i]) {
            for (int j = i; j <= n; j += i) {
                visit[j] = true;
            }
            answer++;
        }
    }
    return answer;
}
int main(void) {
    cout << solution(10) << endl;
    cout << solution(5) << endl;

    return 0;
}