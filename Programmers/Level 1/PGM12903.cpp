#include <iostream>
#include <string>

using namespace std;

/* 문제: 가운데 글자 가져오기 / 분류: 연습문제 */
string solution(string s) {
    string answer = "";
    int len = s.length();

    if (len % 2) answer = s[len / 2];
    else answer = s.substr(len / 2 - 1, 2);
    
    return answer;
}
int main(void) {
    cout << solution("abcde") << endl;
    cout << solution("qwer") << endl;

    return 0;
}