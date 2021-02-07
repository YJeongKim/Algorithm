#include <iostream>
#include <vector>

using namespace std;

/* 문제: 체육복 / 분류: 그리디 */
int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = n;
    vector<int> student(n + 1, 1);

    for (int i = 0; i < lost.size(); i++) {
        student[lost[i]]--;
    }
    for (int i = 0; i < reserve.size(); i++) {
        student[reserve[i]]++;
    }

    for (int i = 1; i <= n; i++) {
        if (student[i] == 0) {
            if (student[i - 1] == 2) {
                student[i]++;
                student[i - 1]--;
            } else if (student[i + 1] == 2) {
                student[i]++;
                student[i + 1]--;
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        if (student[i] == 0) answer--;
    }

    return answer;
}

int main() {
    cout << solution(5, {2, 4}, {1, 3, 5}) << endl;
    cout << solution(5, {2, 4}, {3}) << endl;
    cout << solution(3, {3}, {1}) << endl;

    return 0;
}