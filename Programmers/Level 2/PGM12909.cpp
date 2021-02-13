#include <iostream>
#include <vector>

using namespace std;

/* 문제: 올바른 괄호 / 분류: 연습문제 */
vector<char> stack;

bool solution(string s) {
    bool answer = true;

    for (int i = 0; i < s.length(); i++) {
        if (s[i] == '(') {
            stack.push_back('(');
            continue;
        }
        if (!stack.empty()) {
            stack.pop_back();
        } else {
            answer = false;
            break;
        }
    }
    if (!stack.empty()) answer = false;

    return answer;
}
int main(void) {
    cout << (solution("()()") ? "true" : "fasle") << endl;
    cout << (solution("(())()") ? "true" : "fasle") << endl;
    cout << (solution(")()(") ? "true" : "fasle") << endl;
    cout << (solution("(()(") ? "true" : "fasle") << endl;

    return 0;
}