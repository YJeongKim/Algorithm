#include <iostream>

using namespace std;

/* 문제: 자릿수 더하기 / 분류: 연습문제 */
int solution(int n) {
    int answer = 0;

    while (n > 0) {
        answer += n % 10;
        n /= 10;
    }

    return answer;
}
int main(void) {
    cout << solution(123) << endl;
    cout << solution(987) << endl;
    cout << solution(2468) << endl;

    return 0;
}