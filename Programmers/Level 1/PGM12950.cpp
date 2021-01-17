#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* 문제: 행렬의 덧셈 / 분류: 연습문제 */
vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    vector<vector<int>> answer = arr1;
    int row = answer.size();
    int col = answer[0].size();

    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            answer[i][j] += arr2[i][j];
        }
    }
    return answer;
}
int main(void) {
    vector<vector<int>> a1 = {{1, 2}, {2, 3}};
    vector<vector<int>> a2 = {{3, 4}, {5, 6}};
    vector<vector<int>> b1 = {{1}, {2}};
    vector<vector<int>> b2 = {{3}, {4}};
    vector<vector<int>> result;

    result = solution(a1, a2);
    for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result[0].size(); j++) {
            cout << result[i][j] << " ";
        }
        cout << endl;
    }

    result = solution(b1, b2);
    for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result[0].size(); j++) {
            cout << result[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}