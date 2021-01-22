#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* 문제: 핸드폰 번호 가리기 / 분류: 연습문제 */
string solution(string phone_number) {
    string answer = phone_number;

    answer.replace(answer.begin(), answer.end() - 4, answer.size() - 4, '*');

    return answer;
}
int main(void) {
    cout << solution("01033334444") << endl;
    cout << solution("027778888") << endl;

    return 0;
}