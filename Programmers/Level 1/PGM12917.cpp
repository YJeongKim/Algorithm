#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

/* 문제: 문자열 내림차순으로 배치하기 / 분류: 연습문제 */
bool compare(char s1, char s2) {
    return s1 > s2;
}
string solution(string s) {
    string answer = s;
    sort(answer.begin(), answer.end(), compare);
    return answer;
}
int main(void) {
    string s1 = "Zbcdefg";
    string s2 = "uiEhDWposF";

    cout << solution(s1) << endl;
    cout << solution(s2) << endl;

    return 0;
}