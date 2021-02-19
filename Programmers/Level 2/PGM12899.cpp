#include <iostream>
#include <vector>
#include <string>

using namespace std;

/* 문제: 124 나라의 숫자 / 분류: 연습문제 */
string func(int n, string answer) {
    char rule[3] = {'4', '1', '2'};

    if (n == 0) {
        return answer;
    } else {
        answer = (rule[n % 3]) + answer;
        if (n % 3 == 0)
            return func(n / 3 - 1, answer);
        else
            return func(n / 3, answer);
    }
}
string solution(int n) {
    string answer = func(n, "");
    return answer;
}
int main(void) {
    cout << solution(1) << endl;
    cout << solution(2) << endl;
    cout << solution(3) << endl;
    cout << solution(4) << endl;
    cout << solution(15) << endl;
    cout << solution(20) << endl;

    return 0;
}