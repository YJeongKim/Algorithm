#include <iostream>
#include <string>

using namespace std;

/* 문제: 숫자의 표현 / 분류: 연습문제 */
int solution(int n) {
    int answer = 1; // 자기 자신 포함이므로 1로 시작

    for (int i = 1; i < n / 2 + 1; i++) {
        int sum = 0, idx = i;
        while (sum < n) {
            sum += idx++;
            if (sum == n) {
                answer++;
                break;
            }
        }
    }
    return answer;
}
int main(void) {
    cout << solution(15) << endl;
    cout << solution(27) << endl;

    return 0;
}