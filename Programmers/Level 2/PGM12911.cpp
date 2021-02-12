#include <iostream>

using namespace std;

/* 문제: 다음 큰 숫자 / 분류: 연습문제 */
int binaryCount(int n) {
    int cnt = 0;
    while (n > 0) {
        if (n % 2 == 1) cnt++;
        n /= 2;
    }
    return cnt;
}
int solution(int n) {
    int answer = n;
    int ncnt = binaryCount(n), acnt = 0;

    while (ncnt != acnt) {
        acnt = binaryCount(++answer);
    }

    return answer;
}
int main(void) {
    cout << solution(78) << endl;
    cout << solution(15) << endl;

    return 0;
}