#include <iostream>
#include <string>

using namespace std;

/* 문제: 시저 암호 / 분류: 연습문제 */
string solution(string s, int n) {
    string answer = "";

    for (int i = 0; i < s.length(); i++) {
        if (s[i] == ' ') {
            answer += ' ';
            continue;
        }
        if (s[i] >= 'a' && s[i] <= 'z' && s[i] + n > 'z')
            s[i] -= 26;
        else if (s[i] >= 'A' && s[i] <= 'Z' && s[i] + n > 'Z')
            s[i] -= 26;
        answer += s[i] + n;
    }

    return answer;
}
int main(void) {
    cout << solution("AB", 1) << endl;
    cout << solution("z", 1) << endl;
    cout << solution("a B z", 4) << endl;

    return 0;
}