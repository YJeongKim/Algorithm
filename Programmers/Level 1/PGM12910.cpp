#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/* 문제: 나누어 떨어지는 숫자 배열 / 분류: 연습문제 */
vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;

    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] % divisor == 0)
            answer.push_back(arr[i]);
    }
    if (answer.size() == 0)
        answer.push_back(-1);
    else
        sort(answer.begin(), answer.end());

    return answer;
}
int main(void) {
    vector<int> arr1 = {5, 9, 7, 10};
    vector<int> arr2 = {2, 36, 1, 3};
    vector<int> arr3 = {3, 2, 6};

    for (int n : solution(arr1, 5))
        cout << n << " ";
    cout << endl;
    for (int n : solution(arr2, 1))
        cout << n << " ";
    cout << endl;
    for (int n : solution(arr3, 10))
        cout << n << " ";
    cout << endl;

    return 0;
}