#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;

/* 문제: 소수 만들기 / 분류: Summer/Winter Coding(~2018) */
bool primeNum[3000];

void findPrimeNumbers(int n) {
    for (int i = 2; i <= n; i++) {
        primeNum[i] = true;
    }
    for (int i = 2; i <= n; i++) {
        if (primeNum[i] == false) continue;
        for (int j = i * i; j <= n; j += i) {
            primeNum[j] = false;
        }
    }
}
int solution(vector<int> nums) {
    int answer = 0;
    vector<int> temp = nums;
    int maxVal = 0, size = nums.size();
    stack<int> s;

    sort(temp.rbegin(), temp.rend());
    for (int i = 0; i < 3; i++)
        maxVal += temp[i];
    findPrimeNumbers(maxVal);

    for (int i = 0; i < size - 2; i++) {
        int sum = nums[i];
        s.push(nums[i]);
        for (int j = i + 1; j < size - 1; j++) {
            sum += nums[j];
            s.push(nums[j]);
            int k = j;
            while (k + 1 < size) {
                if (s.size() < 3) {
                    sum += nums[++k];
                    s.push(nums[k]);
                }
                if (s.size() == 3 && primeNum[sum]) answer++;
                sum -= s.top();
                s.pop();
            }
            sum -= s.top();
            s.pop();
        }
        s.pop();
    }

    return answer;
}
int main(void) {
    cout << solution({1, 2, 3, 4}) << endl;
    cout << solution({1, 2, 7, 6, 4}) << endl;

    return 0;
}