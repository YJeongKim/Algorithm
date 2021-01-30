#include <iostream>
#include <string>

using namespace std;

/* 문제: 문자열을 정수로 바꾸기 / 분류: 연습문제 */
int solution(string s) {
    int answer = 0;

    answer = stoi(s);

    return answer;
}
int main(void) {
    cout << solution("1234") << endl;
    cout << solution("-1234") << endl;

    return 0;
}