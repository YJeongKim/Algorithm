#include <iostream>
#include <string>

using namespace std;

/* 문제: 수박수박수박수박수박수? / 분류: 연습문제 */
string solution(int n) {
    string answer = "";

    for (int i = 1; i <= n; i++) {
        if (i % 2) answer += "수";
        else answer += "박";
    }
    
    return answer;
}
int main(void) {
    cout << solution(3) << endl;
    cout << solution(4) << endl;

    return 0;
}