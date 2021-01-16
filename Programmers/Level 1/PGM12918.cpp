#include <iostream>
#include <string>
#include <vector>
#include <cctype>

using namespace std;

/* 문제: 문자열 다루기 기본 / 분류: 연습문제 */
bool solution(string s) {
    bool answer = true;
    int length = s.length();

    if (length != 4 && length != 6) {
        answer = false;
    }
    else {
        for (int i = 0; i < length; i++) {
            if (isdigit(s[i]) == 0) {
                answer = false;
                break;
            }
        }
     /* for (int i = 0; i < length; i++) {
            if (s[i] < '0' || s[i] > '9') {
                answer = false;
                break;
            }
        } */
    }

    return answer;
}
int main(void) {
    string s1 = "a123";
    string s2 = "012345";

    cout << "s1 : " << (solution(s1) ? "true" : "false") << endl;
    cout << "s2 : " << (solution(s2) ? "true" : "false") << endl;

    return 0;
}