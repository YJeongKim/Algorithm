#include <iostream>

using namespace std;

/* 문제: 약수의 합 / 분류: 연습문제 */
int solution(int n) {
    int answer = 0;

    for (int i = 1; i <= n; i++) {
        if (n % i == 0) answer += i;
    }

    return answer;
}
int main(void) {
    cout << solution(12) << endl;
    cout << solution(5) << endl;

    return 0;
}