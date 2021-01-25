#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* 문제: 짝수와 홀수 / 분류: 연습문제 */
string solution(int num) {
    string answer = (num % 2) ? "Odd" : "Even";
    return answer;
}
int main(void) {
    vector<int> arr = {3, 4, 0, 15};

    for (int num : arr) cout << solution(num) << endl;

    return 0;
}