#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* 문제: x만큼 간격이 있는 n개의 숫자 / 분류: 연습문제 */
vector<long long> solution(int x, int n) {
    vector<long long> answer;
    for (int i = 1; i <= n; i++) {
        answer.push_back(i * x);
    }
    return answer;
}
int main(void) {
    for (long long r : solution(2, 5)) cout << r << " ";
    cout << endl;

    for (long long r : solution(4, 3)) cout << r << " ";
    cout << endl;

    for (long long r : solution(-4, 2)) cout << r << " ";
    cout << endl;

    return 0;
}