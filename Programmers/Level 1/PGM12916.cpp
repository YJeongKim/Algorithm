#include <iostream>
#include <string>

using namespace std;

/* 문제: 문자열 내 p와 y의 개수 / 분류: 연습문제 */
bool solution(string s) {
    bool answer = true;
    int p = 0, y = 0;

    for (int i = 0; i < s.length(); i++) {
        if (s[i] == 'p' || s[i] == 'P') p++;
        else if (s[i] == 'y' || s[i] == 'Y') y++;
    }
    answer = (p == y) ? true : false;
    return answer;
}
int main(void) {
    string s1 = "pPoooyY";
    string s2 = "Pyy";

    cout << (solution(s1) ? "true" : "false") << endl;
    cout << (solution(s2) ? "true" : "false") << endl;

    return 0;
}