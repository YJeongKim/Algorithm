#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/* 문제: 예산 / 분류: Summer/Winter Coding(~2018), 그리디 */
int solution(vector<int> d, int budget) {
    int answer = 0;
    int sum = 0;

    sort(d.begin(), d.end());
    for (int i = 0; i < d.size(); i++) {
        if (sum + d[i] <= budget) {
            sum += d[i];
            answer++;
        }
    }
    return answer;
}
int main(void) {
    vector<int> d1 = {1, 3, 2, 5, 4};
    vector<int> d2 = {2, 2, 3, 3};

    cout << solution(d1, 9) << endl;
    cout << solution(d2, 10) << endl;

    return 0;
}