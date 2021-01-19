#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* 문제: 하샤드 수 / 분류: 연습문제 */
bool solution(int x) {
    bool answer = true;
    int sum = 0;

    for (int i = x; i > 0; i /= 10) {
        sum += i % 10;
    }
    if (x % sum) answer = false;

    return answer;
}
int main(void) {
    vector<int> arr = {10, 12, 11, 13};

    for(int x : arr) {
        string result = solution(x) ? "true" : "false";
        cout << result << endl;
    }

    return 0;
}