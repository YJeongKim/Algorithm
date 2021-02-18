#include <iostream>
#include <string>
#include <stack>

using namespace std;

/* 문제: 짝지어 제거하기 / 분류: 2017 팁스타운, 스택 */
int solution(string s) {
    stack<char> st;

    for (int i = 0; i < s.length(); i++) {
        if (!st.empty() && st.top() == s[i]) st.pop();
        else st.push(s[i]);
    }
    return (st.size() == 0) ? 1 : 0;
}
int main(void) {
    cout << solution("baabaa") << endl;
    cout << solution("cdcd") << endl;

    return 0;
}