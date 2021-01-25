#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/* 문제: 제일 작은 수 제거하기 / 분류: 연습문제 */
vector<int> solution(vector<int> arr) {
    vector<int> answer;

    if (arr.size() == 1) {
        answer.push_back(-1);
        return answer;
    }
    answer = arr;
    sort(arr.begin(), arr.end());
    for (int i = 0; i < arr.size(); i++) {
        if (arr[0] == answer[i])
            answer.erase(answer.begin() + i);
    }

    return answer;
}
int main(void) {
    vector<vector<int>> arr = {{4, 3, 2, 1}, {10}};

    for (vector<int> a : arr) {
        for(int n : solution(a))
            cout << n << " ";
        cout << endl;
    }

    return 0;
}