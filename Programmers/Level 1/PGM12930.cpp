#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* 문제: 이상한 문자 만들기 / 분류: 연습문제 */
string solution(string s) {
    string answer = "";
    int idx = 0;

    for (int i = 0; i < s.length(); i++) {
        if (idx % 2 == 0 && s[i] >= 'a' && s[i] <= 'z') {
            s[i] -= 32;
        }
        else if (idx % 2 == 1 && s[i] >= 'A' && s[i] <= 'Z') {
            s[i] += 32;
        }
        answer += s[i];
        idx++;
        if (s[i] == ' ') idx = 0;
    }
    return answer;
}
int main(void) {
    cout << solution("try hello world") << endl;
    cout << solution("you are so fun") << endl;

    return 0;
}