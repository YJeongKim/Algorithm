#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* 문제: 2016년 / 분류: 연습문제 */
string solution(int a, int b) {
    string answer = "";
    string day[7] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    int month[12] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    for (int i = 0; i < a - 1; i++) {
        b += month[i];
    }
    answer = day[(b + 4) % 7];
    return answer;
}
int main(void) {
    cout << solution(5, 24) << endl;
    cout << solution(4, 30) << endl;
    cout << solution(8, 12) << endl;

    return 0;
}