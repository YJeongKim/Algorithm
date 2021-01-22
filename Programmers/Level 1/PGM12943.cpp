#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* 문제: 콜라츠 추측 / 분류: 연습문제 */
int solution(int num) {
    int answer = 0;
    long long n = num;

    while (n != 1) {
        answer++;
        if (answer > 500) {
            answer = -1;
            break;
        }
        if (n % 2 == 0) n /= 2;
        else n = n * 3 + 1;
    }
    
    return answer;
}
int main(void) {
    vector<int> arr = {6, 16, 626331};

    for (int n : arr) {
        cout << solution(n) << endl;
    }

    return 0;
}