#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

/* 문제: 정수 내림차순으로 배치하기 / 분류: 연습문제 */
bool compare(char c1, char c2) {
    return c1 > c2;
}
long long solution(long long n) {
    long long answer = 0;
    string number = to_string(n);

    sort(number.begin(), number.end(), compare);
    answer = atoll(number.c_str());

    return answer;
}
int main(void) {
    cout << solution(118372) << endl;
    cout << solution(25891) << endl;
    cout << solution(572481) << endl;

    return 0;
}