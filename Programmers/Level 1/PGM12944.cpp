#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* 문제: 평균 구하기 / 분류: 연습문제 */
double solution(vector<int> arr) {
    double answer = 0;
    for (int i = 0; i < arr.size(); i++) {
        answer += arr[i];
    }
    answer /= arr.size();
    return answer;
}
int main(void) {
    vector<int> arr1 = {1, 2, 3, 4};
    vector<int> arr2 = {5, 5};

    cout << solution(arr1) << endl;
    cout << solution(arr2) << endl;

    return 0;
}