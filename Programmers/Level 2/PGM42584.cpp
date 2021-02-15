#include <iostream>
#include <vector>

using namespace std;

/* 문제: 주식가격 / 분류: 스택, 큐 */
vector<int> solution(vector<int> prices) {
    vector<int> answer;

    for (int i = 0; i < prices.size(); i++) {
        int sec = 0;
        for (int j = i + 1; j < prices.size(); j++) {
            sec++;
            if (prices[i] > prices[j]) break;
        }
        answer.push_back(sec);
    }
    return answer;
}
int main(void) {
    for (int n : solution({1, 2, 3, 2, 3}))
        cout << n << " ";
    cout << endl;

    return 0;
}